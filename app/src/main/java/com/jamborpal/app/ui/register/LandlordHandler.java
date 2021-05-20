package com.jamborpal.app.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jamborpal.app.R;

public class LandlordHandler extends AppCompatActivity {


    EditText phone;
    EditText email;
    Button saveing;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord);
        saveing = this.findViewById(R.id.saveLandlord);

        phone = findViewById(R.id.phoneNum_landlord);
        email = findViewById(R.id.email_landlord);
        Intent intent = new Intent(this, LocationHandler.class);


        saveing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("LANDLORD_EMAIL", email.getText().toString());
                intent.putExtra("LANDLORD_PHONE", phone.getText().toString());


                intent.putExtra("FLATMATE_USERNAME", getIntent().getStringExtra("FLATMATE_USERNAME"));
                intent.putExtra("FLATMATE_PASSWORD",getIntent().getStringExtra("FLATMATE_PASSWORD"));
                intent.putExtra("FLATMATE_FULLNAME", getIntent().getStringExtra("FLATMATE_FULLNAME"));
                intent.putExtra("FLATMATE_EMAIL", getIntent().getStringExtra("FLATMATE_EMAIL"));
                intent.putExtra("FLATMATE_PHONENUMBER", getIntent().getStringExtra("FLATMATE_PHONENUMBER"));

                startActivity(intent);
                finish();
            }
        });

    }


}