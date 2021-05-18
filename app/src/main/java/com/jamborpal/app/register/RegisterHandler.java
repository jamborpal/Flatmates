package com.jamborpal.app.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jamborpal.app.R;
import com.jamborpal.app.login.LoginHandler;
import com.jamborpal.app.model.Flatmate;

import java.util.Objects;

public class RegisterHandler extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText fullname;
    private EditText password;
    private EditText repeatpassword;
    private TextView error;
    private EditText phone;
    boolean checkIfNotCorrect;
    DatabaseReference myRef;
    FirebaseDatabase database;

    public RegisterHandler() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //defining the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        //initializing view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repeatpassword = findViewById(R.id.repeatpassword);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        error = findViewById(R.id.error_register);
        phone = findViewById(R.id.phoneNum);

        //adding onClick listener to buttons
        final Button register = findViewById(R.id.register_1);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Register();
            }
        });

        //initializin variables
        this.checkIfNotCorrect = false;
    }

    public void Login(View view) {
        Intent intent = new Intent(this, LoginHandler.class);
        startActivity(intent);
    }

    public void Register() {
        Intent intent = new Intent(this, LocationHandler.class);

        if (repeatpassword.getText().toString().equals(password.getText().toString()) && repeatpassword.getText().toString().length() > 7) {

            myRef.child("flats").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        for (DataSnapshot snapshot2 : snapshot1.child("tenants").getChildren()) {
                            if (username.getText().toString().equals(Objects.requireNonNull(snapshot2.child("username")
                                    .getValue()))) {
                                error.setText(R.string.username_used);
                                checkIfNotCorrect = true;
                                return;
                            }
                            if (!(email.getText().toString().contains("@"))) {
                                error.setText(R.string.valid_email);

                                return;
                            } else {
                                checkIfNotCorrect = false;
                                error.setText("");
                            }

                        }

                    }
                    if (!checkIfNotCorrect) {

                        intent.putExtra("FLATMATE_USERNAME", username.getText().toString());
                        intent.putExtra("FLATMATE_PASSWORD", password.getText().toString());
                        intent.putExtra("FLATMATE_FULLNAME", fullname.getText().toString());
                        intent.putExtra("FLATMATE_EMAIL", email.getText().toString());
                        intent.putExtra("FLATMATE_PHONENUMBER", phone.getText().toString());

                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        } else error.setText(R.string.register_error);

    }
}
