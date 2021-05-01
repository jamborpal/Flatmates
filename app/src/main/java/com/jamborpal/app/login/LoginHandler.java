package com.jamborpal.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jamborpal.app.MainActivity;
import com.jamborpal.app.R;
import com.jamborpal.app.register.RegisterHandler;

public class LoginHandler extends AppCompatActivity {
    private LoginViewModel loginViewModel;

    public LoginHandler() {
        this.loginViewModel = new LoginViewModel();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Login(View view) {



        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();
    }

    public void Register(View view) {
        Intent intent = new Intent(this, RegisterHandler.class);
        startActivity(intent);
    }
}
