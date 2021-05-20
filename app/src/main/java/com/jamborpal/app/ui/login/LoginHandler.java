package com.jamborpal.app.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jamborpal.app.MainActivity;
import com.jamborpal.app.R;
import com.jamborpal.app.ui.register.RegisterHandler;

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
        TempDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));


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

                } else {
                    error.setText(R.string.fill);
                }


            }
        });
    }


    public void Login(String username, String password) {
        if (loginViewModel.login(username, password)) {
            Intent intent = new Intent(this, MainActivity.class);
            TempDialog.dismiss();
            startActivityForResult(intent, RESULT_OK);
            finish();

        } else {

            error.setText(R.string.login_exists);
            TempDialog.dismiss();
        }


    }

    public void Register(View view) {
        Intent intent = new Intent(this, RegisterHandler.class);
        startActivity(intent);
    }
}
