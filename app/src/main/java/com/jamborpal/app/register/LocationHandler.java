package com.jamborpal.app.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jamborpal.app.MainActivity;
import com.jamborpal.app.R;
import com.jamborpal.app.login.LoginHandler;
import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Event;
import com.jamborpal.app.model.Expense;
import com.jamborpal.app.model.Flat;
import com.jamborpal.app.model.Flatmate;

import java.util.ArrayList;

public class LocationHandler extends AppCompatActivity {
    Flatmate flatmate;
    EditText country;
    EditText city;
    EditText address;
    EditText flatid;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        country = findViewById(R.id.country);
        city = findViewById(R.id.cityk);
        address = findViewById(R.id.address);
        flatid = findViewById(R.id.flatID);
        this.flatmate = new Flatmate(getIntent().getStringExtra("FLATMATE_FULLNAME"), getIntent().getStringExtra("FLATMATE_EMAIL"), getIntent().getStringExtra("FLATMATE_USERNAME"), getIntent().getStringExtra("FLATMATE_PASSWORD"));
        final Button location = findViewById(R.id.adding_location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
    }

    public void choose(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void add() {
        Intent intent = new Intent(this, LoginHandler.class);
        Flat flat = new Flat(flatid.getText().toString(), city.getText().toString(), country.getText().toString(), address.getText().toString());

        flat.MoveIn(flatmate);
        /*ArrayList<Integer> strings = new ArrayList<>();
        int string1 = 2;
        int string2 = 2;
        int string3 = 2;
        strings.add(string1);strings.add(string2);
        strings.add(string3);*/
        Expense expense = new Expense("sdsd", 12.3, 12);
        Chore chore = new Chore("asds", "svsdsbefdfbsf");
        Event event = new Event("titssd", "sdsadvds", "fsddwfdvdfdsa", 1232143);
        flat.OrganizeEvent(event);
        flat.AddChore(chore);
        flat.AddExpense(expense);

        myRef.child("flats").child(flatid.getText().toString()).setValue(flat);
        startActivity(intent);
        finish();
    }
}
