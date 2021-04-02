package com.jamborpal.app.register;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jamborpal.app.R;
import com.jamborpal.app.login.LoginHandler;

public class RegisterHandler extends AppCompatActivity {
    public RegisterHandler(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Login(View view) {
        Intent intent = new Intent(this, LoginHandler.class);
        startActivity(intent);
    }

    public void Register(View view) {
        Intent intent = new Intent(this, LoginHandler.class);
        startActivity(intent);
    }
}
