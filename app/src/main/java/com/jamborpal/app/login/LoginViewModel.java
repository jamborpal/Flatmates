package com.jamborpal.app.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jamborpal.app.model.Flat;
import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.List;

public class LoginViewModel extends ViewModel {
    private Model model;
    DatabaseReference myRef;
    FirebaseDatabase database;
    private Flat flat;

    public LoginViewModel() {
        this.model = new ModelManager();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }

    public void login(String username, String password) {

        myRef.child("flats").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {


                    flat = snapshot1.getValue(Flat.class);
                    System.out.println(flat.address);
                            /*if (flat.getUsername().equals(username) && flat.getPassword().equals(password)) {

                                model.setLoggedInUser(flat);
                                return;
                            }*/


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public String getsomething() {
        return model.getLoggedInUser().getFullname();
    }

}
