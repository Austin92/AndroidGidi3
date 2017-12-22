package com.example.aanya.gidi3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private Button btnRegister;
    private EditText etFirstName, etLastName, etUsername,etEmailAddress,
            etPassword;
    TextView tvSignInLink;
    Spinner spinneritem1;
    Spinner spinneritem2;
    Spinner spinneritem3;
    Spinner spinneritem4;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            //profile Activity.
            finish();
            startActivity(new Intent(getApplicationContext(),Profile.class));


        }

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmailAddress = (EditText) findViewById(R.id.etEmailAddress);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        spinneritem1 = (Spinner) findViewById(R.id.spinner1);
        spinneritem1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case  0:
                        Toast.makeText(getApplicationContext(),"Ireland selected",Toast.LENGTH_LONG).show();
                        break;
                    case  1:
                        Toast.makeText(getApplicationContext(),"UK selected",Toast.LENGTH_LONG).show();
                        break;
                    case  2:
                        Toast.makeText(getApplicationContext(),"Sweden selected",Toast.LENGTH_LONG).show();
                        break;
                    case  3:
                        Toast.makeText(getApplicationContext(),"Japan selected",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinneritem2 = (Spinner) findViewById(R.id.spinner2);
        spinneritem2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long is) {
                switch (position){
                    case  0:
                        Toast.makeText(getApplicationContext(),"Age group selected",Toast.LENGTH_LONG).show();
                        break;
                    case  1:
                        Toast.makeText(getApplicationContext(),"Age group selected",Toast.LENGTH_LONG).show();
                        break;
                    case  2:
                        Toast.makeText(getApplicationContext(),"Age group selected",Toast.LENGTH_LONG).show();
                        break;
                    case  3:
                        Toast.makeText(getApplicationContext(),"Age group selected",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinneritem3 = (Spinner) findViewById(R.id.spinner3);
        spinneritem3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case  0:
                        Toast.makeText(getApplicationContext(),"Male selected",Toast.LENGTH_LONG).show();
                        break;
                    case  1:
                        Toast.makeText(getApplicationContext(),"Female selected",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinneritem4 = (Spinner) findViewById(R.id.spinner4);
        spinneritem4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case  0:
                        Toast.makeText(getApplicationContext(),"5'0 to 5'5 selected",Toast.LENGTH_LONG).show();
                        break;
                    case  1:
                        Toast.makeText(getApplicationContext(),"5'6 to 5'11 selected",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"6'0 to 6'5 selected",Toast.LENGTH_LONG).show();
                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
                Intent intent = new Intent(Register.this,GidiActivity.class);
                startActivity(intent);
            }
        });

    }

    private void registerUser() {
        String firstname = etFirstName.getText().toString().trim();
        String lastname = etLastName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String emailaddress = etEmailAddress.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(firstname)){
            Toast.makeText(this,"Please enter FirstName",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(lastname)){
            Toast.makeText(this,"Please enter LastName",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"Please enter UserName",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(emailaddress)){
            Toast.makeText(this,"Please enter EmailAddress",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(emailaddress,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),Profile.class));
                            Toast.makeText(Register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Register.this, "Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
