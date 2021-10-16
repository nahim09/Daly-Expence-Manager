package com.example.dalyexpencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText,passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getSupportActionBar().hide();

        tint();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String pass = passwordEditText.getText().toString().trim();

                if (email.equals("")){
                    emailEditText.setError("Please Email can't be empty");
                    emailEditText.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    emailEditText.setError("Enter a valid email address");
                    emailEditText.requestFocus();
                    return;
                }
                if (pass.equals("")||pass.length()<4){
                    passwordEditText.setError("password must be 4 character");
                    passwordEditText.requestFocus();
                    return;
                }

                DBHelper dbHelper = new DBHelper(LoginActivity.this);
                int value= dbHelper.loginUser(email,pass);
                if (value==0){
                    Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }

            }
        });

    }

    private void tint() {
        emailEditText = findViewById(R.id.email_textId);
        passwordEditText = findViewById(R.id.password_textId);
        loginButton = findViewById(R.id.bt_Submit);
    }

}