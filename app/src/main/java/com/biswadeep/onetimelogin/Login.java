package com.biswadeep.onetimelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email= findViewById(R.id.email_id);
        password= findViewById(R.id.password_id);
        login= findViewById(R.id.login_id);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().trim().isEmpty()) {
                    email.setError("Input email!");
                }
                else if (password.getText().toString().trim().isEmpty()) {
                    password.setError("Input password!");
                }
                else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                    Shared shared= new Shared(getApplicationContext());

                    shared.secondTime();

                }
            }
        });
    }
}