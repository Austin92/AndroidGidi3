package com.example.aanya.gidi3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity implements View.OnClickListener  {
    Button btnLogIn;
    EditText etEmailAddress,etPassword;
    TextView tvRegisterLink;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            //profile Activity.
            finish();
            startActivity(new Intent(getApplicationContext(),GidiActivity.class));


        }


        etEmailAddress = (EditText)findViewById(R.id.etEmailAddress);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        btnLogIn.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
    }

    private void usersignIn(){
        String emailaddress = etEmailAddress.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(emailaddress)){
            Toast.makeText(this,"Please enter a valid Email Address",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter a valid Password",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(emailaddress,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            //Start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(),GidiActivity.class));


                        }

                    }
                });
    }

    @Override
    public void onClick(View view){
        if(view == btnLogIn ){
            usersignIn();


        }
        if (view == tvRegisterLink ){
            finish();
            startActivity(new Intent(this,Register.class));
        }
    }
}
