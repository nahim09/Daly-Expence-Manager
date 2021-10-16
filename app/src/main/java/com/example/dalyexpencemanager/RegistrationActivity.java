package com.example.dalyexpencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText nameEt,emailEt,passWordEt,confrompasswordEt;

    private Button buttonRg;
    private TextView loginTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        getSupportActionBar().hide();

        tint();

        buttonRg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString().trim();
                String email = emailEt.getText().toString().trim();
                String pass = passWordEt.getText().toString().trim();
                String cPass = confrompasswordEt.getText().toString().trim();

                if (name.equals("")){
                    nameEt.setError("Please name must be 4 character");
                    nameEt.requestFocus();
                    return;
                }
                if (email.equals("")){
                    emailEt.setError("Please Email can't be empty");
                    emailEt.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    emailEt.setError("Enter a valid email address");
                    emailEt.requestFocus();
                    return;
                }
                if (pass.equals("")||pass.length()<4){
                    passWordEt.setError("password must be 4 character");
                    passWordEt.requestFocus();
                    return;
                }
                if (!(cPass.equals(pass))){
                    confrompasswordEt.setError("Sorry Password don't match");
                    confrompasswordEt.requestFocus();
                    return;
                }

                UserModel userModel = new UserModel(name,email,pass);
                DBHelper dbHelper = new DBHelper(RegistrationActivity.this);
                long rowId = dbHelper.insertUser(userModel);

                if (rowId>0){
                    Toast.makeText(RegistrationActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                }else {
                    Toast.makeText(RegistrationActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

    }

    private void tint() {
        nameEt = findViewById(R.id.et_name);
        emailEt = findViewById(R.id.et_email);
        passWordEt = findViewById(R.id.et_Password);
        confrompasswordEt = findViewById(R.id.et_Con_Password);
        buttonRg = findViewById(R.id.Rg_submitbt);
        loginTv=findViewById(R.id.loginhere_id);
    }

}