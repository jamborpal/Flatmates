package com.jamborpal.app.database;

import com.google.firebase.database.FirebaseDatabase;

public class DatabaseAccess {
    private FirebaseDatabase database;

    public DatabaseAccess() {
        this.database = FirebaseDatabase.getInstance();
    }
}
