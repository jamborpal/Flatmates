package com.jamborpal.app.database;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jamborpal.app.model.Flatmate;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private static DatabaseAccess databaseAccess;


    public DatabaseAccess() {
        this.database = FirebaseDatabase.getInstance();
        this.myRef = database.getReference();
    }
    public synchronized static DatabaseAccess getInstance(){
        if(databaseAccess==null){
            databaseAccess = new DatabaseAccess();
        }
        return databaseAccess;
    }

    public Flatmate getFlatmate(String username, String password) {
        final Flatmate[] flatmate1 = {new Flatmate()};
        myRef.child("flats").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    List<Flatmate> flatmates = new ArrayList<>();
                    for (DataSnapshot snapshot2 : snapshot1.child("tenants").getChildren()) {
                        Flatmate flatmate = snapshot2.getValue(Flatmate.class);
                        if (flatmate.getUsername().equals(username) && flatmate.getPassword().equals(password)) {
                            flatmate1[0] = flatmate;
                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return flatmate1[0];
    }
}
