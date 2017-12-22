package com.example.aanya.gidi3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity implements View.OnClickListener  {

    private FirebaseAuth firebaseAuth;
    private TextView userEmail;
    private Button btnLogOut;

    private DatabaseReference databaseReference;

    private EditText editPassword,editEmail,editAge,editWeight;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, SignIn.class));
        }


        databaseReference = FirebaseDatabase.getInstance().getReference();

        editPassword=(EditText) findViewById(R.id.editPassword);
        editEmail=(EditText) findViewById(R.id.editEmail);
        editAge=(EditText) findViewById(R.id.editAge);
        editWeight=(EditText) findViewById(R.id.editWeight);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        userEmail = (TextView) findViewById(R.id.userEmail);
        userEmail.setText("Welcome  " +user.getEmail());

        userEmail = (TextView) findViewById(R.id.userEmail);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLogOut.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    private void saveUserDetails(){
        String password = editPassword.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String age = editAge.getText().toString().trim();
        String weight = editWeight.getText().toString().trim();

        UserDetails userDetails = new UserDetails(password, email, age, weight);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userDetails);
        Toast.makeText(this, "details saved", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        if (view == btnLogOut){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, SignIn.class));
        }
        if (view == btnSave){
            saveUserDetails();
        }

    }
}
