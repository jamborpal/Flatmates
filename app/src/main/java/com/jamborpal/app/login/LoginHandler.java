package com.jamborpal.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jamborpal.app.MainActivity;
import com.jamborpal.app.R;
import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.register.RegisterHandler;

public class LoginHandler extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private EditText username;
    private EditText password;

    public LoginHandler() {
        this.loginViewModel = new LoginViewModel();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //initialize fields
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        this.loginViewModel = new LoginViewModel();
        //adding onClick listener to the login button
        final Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login(username.getText().toString(), password.getText().toString());
            }
        });
    }

    public void Login(String username, String password) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void Register(View view) {
        Intent intent = new Intent(this, RegisterHandler.class);
        startActivity(intent);
    }
}
