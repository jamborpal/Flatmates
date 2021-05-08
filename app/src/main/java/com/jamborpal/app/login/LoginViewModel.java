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

import java.util.ArrayList;
import java.util.List;

public class LoginViewModel extends ViewModel {
    private Model model;
    public LoginViewModel() {
        this.model = ModelManager.getInstance();
    }

    public void login(String username,String password) {
       model.login(username, password);
    }

}
