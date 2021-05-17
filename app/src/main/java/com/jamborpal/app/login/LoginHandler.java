package com.jamborpal.app.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;

import com.jamborpal.app.MainActivity;
import com.jamborpal.app.R;
import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.register.RegisterHandler;

import java.io.File;
import java.util.concurrent.CountDownLatch;

public class LoginHandler extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private EditText username;
    private EditText password;
    ProgressDialog TempDialog;
    CountDownTimer countDownTimer;
    public TextView error;

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
        error = findViewById(R.id.error_login);
        this.loginViewModel = new LoginViewModel();

        TempDialog = new ProgressDialog(LoginHandler.this);
        TempDialog.setMessage("Please wait...");
        TempDialog.setCancelable(false);
        TempDialog.setProgress(0);
        TempDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        TempDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));


        //adding onClick listener to the login button
        final Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!username.getText().toString().equals("") && !password.getText().toString().equals("")) {

                    countDownTimer = new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            TempDialog.setMessage("Please wait...");
                        }

                        @Override
                        public void onFinish() {
                            TempDialog.dismiss();

                        }
                    }.start();
                    TempDialog.show();
                    Login(username.getText().toString(), password.getText().toString());


                }
            }
        });
    }

    public void Login(String username, String password) {

        loginViewModel.login(username, password);
        Intent intent = new Intent(this, MainActivity.class);
        TempDialog.dismiss();
        startActivityForResult(intent, RESULT_OK);
        finish();


    }

    public void Register(View view) {
        Intent intent = new Intent(this, RegisterHandler.class);
        startActivity(intent);
    }
}
