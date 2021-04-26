package com.jamborpal.app.register;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jamborpal.app.R;
import com.jamborpal.app.login.LoginHandler;
import com.jamborpal.app.model.Flatmate;

import java.io.Serializable;

public class RegisterHandler extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText fullname;
    private EditText password;
    private EditText repeatpassword;
    private TextView error;

    public RegisterHandler() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repeatpassword = findViewById(R.id.repeatpassword);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        error = findViewById(R.id.error_register);
        final Button register = findViewById(R.id.register_1);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("cite", "cute");
                Register();
            }
        });
    }

    public void Login(View view) {
        Intent intent = new Intent(this, LoginHandler.class);
        startActivity(intent);
    }

    public void Register() {

        if (repeatpassword.getText().toString().equals(password.getText().toString())) {

            Intent intent = new Intent(this, LocationHandler.class);

            intent.putExtra("FLATMATE_USERNAME", username.getText().toString());


            startActivity(intent);
        } else error.setText(R.string.register_error);

    }
}
