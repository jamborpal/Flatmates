package com.jamborpal.app.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.jamborpal.app.MainActivity;
import com.jamborpal.app.R;
import com.jamborpal.app.login.LoginHandler;
import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Event;
import com.jamborpal.app.model.Expense;
import com.jamborpal.app.model.Flat;
import com.jamborpal.app.model.Flatmate;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LocationHandler extends AppCompatActivity {
    Flatmate flatmate;
    Flatmate landlord;
    EditText country;
    EditText city;
    EditText address;
    EditText flatid;
    EditText chooseflatID;
    FirebaseDatabase database;
    Flat flat;
    DatabaseReference myRef;
    boolean isUsed;
    TextView error;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //defining the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        //initializing view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        country = findViewById(R.id.country);
        city = findViewById(R.id.cityk);
        address = findViewById(R.id.address);
        flatid = findViewById(R.id.flatID);
        chooseflatID = findViewById(R.id.location_id);
        error = findViewById(R.id.location_error);

        //initializing flatmate and landlord variable
        this.flatmate = new Flatmate(getIntent().getStringExtra("FLATMATE_FULLNAME"),
                getIntent().getStringExtra("FLATMATE_EMAIL"),
                getIntent().getStringExtra("FLATMATE_USERNAME"),
                getIntent().getStringExtra("FLATMATE_PASSWORD"), getIntent().getStringExtra("FLATMATE_PHONENUMBER"));
        this.landlord = null;

        //adding onClick listeners to buttons

        final Button addingLocation = findViewById(R.id.choose_loc);
        addingLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose(chooseflatID.getText().toString());
            }
        });

        final Button location = findViewById(R.id.adding_location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        final Button landlord = findViewById(R.id.landlord);
        landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLandlord();

            }
        });
        this.isUsed = false;
    }

    private void goToLandlord() {
        Intent intent = new Intent(this, LandlordHandler.class);
        intent.putExtra("FLATMATE_USERNAME",   getIntent().getStringExtra("FLATMATE_USERNAME"));
        intent.putExtra("FLATMATE_PASSWORD", getIntent().getStringExtra("FLATMATE_PASSWORD"));
        intent.putExtra("FLATMATE_FULLNAME", getIntent().getStringExtra("FLATMATE_FULLNAME"));
        intent.putExtra("FLATMATE_EMAIL", getIntent().getStringExtra("FLATMATE_EMAIL"));
        intent.putExtra("FLATMATE_PHONENUMBER", getIntent().getStringExtra("FLATMATE_PHONENUMBER"));
        startActivity(intent);
    }

    public void choose(String id) {
        Intent intent = new Intent(this, LoginHandler.class);
        myRef.child("flats").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    String key = snapshot1.getKey();
                    if (key.equals(id)) {
                        myRef.child("flats").child(chooseflatID.getText().toString()).child("tenants").child("" + flatmate.getFlatmateid()).setValue(flatmate);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //sending the current user and flat to the MainActivity

        startActivity(intent);
        finish();
    }

    public void add() {
        Intent intent = new Intent(this, LoginHandler.class);
        myRef.child("flats").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    if (snapshot1.getKey().equals(flatid.getText().toString())) {
                        isUsed = true;
                        error.setText(R.string.location_error);

                        return;
                    } else {
                        isUsed = false;
                        error.setText("");
                    }

                }
                if (!isUsed) {
                    landlord = new Flatmate(getIntent().getStringExtra("Landlord"),
                            getIntent().getStringExtra("LANDLORD_EMAIL"),
                           "Landlord",
                            "", getIntent().getStringExtra("LANDLORD_PHONE"));
                    flat = new Flat(flatid.getText().toString(), city.getText().toString(), country.getText().toString(), address.getText().toString());
                    flat.MoveIn(landlord);
                    flat.MoveIn(flatmate);
                    myRef.child("flats").child(flatid.getText().toString()).setValue(flat);
                    intent.putExtra("LOGGED_IN_USER", flatmate);
                    intent.putExtra("FLAT_IN_USE", flat);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
            }
        });

    }
}
