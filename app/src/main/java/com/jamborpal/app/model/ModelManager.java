package com.jamborpal.app.model;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jamborpal.app.MainActivity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ModelManager implements Model {
    //Add variable of database instance
    public Flatmate LoggedInUser;
    public Flat flat;
    private String flatID;
    private String flatmateID;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private static ModelManager modelManager;

    public synchronized static ModelManager getInstance() {
        if (modelManager == null) {
            modelManager = new ModelManager();
        }
        return modelManager;
    }

    public ModelManager(String flatmateID, String flatID) {
        database = FirebaseDatabase.getInstance();
        myref = database.getReference();
        setFlatUsed(flatID);
        setLoggedInUser(flatmateID);
    }

    public ModelManager() {
        database = FirebaseDatabase.getInstance();
        myref = database.getReference();
      /*  Flatmate flatmate = new Flatmate("Pál Jámbor", "jamborpal0@gmail.com", "jamborpal", "hello");
        Flat flat = new Flat("hello", "Horsens", "Country", "Address");
        this.flat = flat;
        this.LoggedInUser = flatmate;
        Flatmate flatmate1 = new Flatmate("Lola", "jfdsgfdgdfgil.com", "lola", "hello");

        Flatmate flatmate2 = new Flatmate("Emma", "jfdgfdg@gmail.com", "emma", "hello");
        MoveIn(flatmate1);
        MoveIn(flatmate2);*/


     /*   ArrayList<Room> rooms = new ArrayList<>();
        Room room1 = new Room("Room1");
        Room room2 = new Room("Room2");
        Room room3 = new Room("Room3");
        this.flat = new Flat("firstflat","Horsens", "Denmark", "Radhustorvet");
        this.LoggedInUser = new Flatmate("Pál Jámbor", "jamborpal@gmail.com", "jamborpal", "1234");
        LoggedInUser.setPhoneNumber(0211313);
        Flatmate flatmate = new Flatmate("Toyota", "toyi@gmail.om", "toy", "1234");
        flatmate.setPhoneNumber(32432432);
        Chore chore = new Chore("title", "desctiption");Chore chore1 = new Chore("titlsfdge", "descfdsgfdsfsfsaftiption");
        flat.AddChore(chore1);
        flat.AddChore(chore);*/
    }

    @Override
    public void login(String username, String password) {

        myref.child("flats").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public synchronized void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    for (DataSnapshot snapshot2 : snapshot1.child("tenants").getChildren()) {
                        Flatmate flatmate = snapshot2.getValue(Flatmate.class);
                        if (flatmate.getUsername().equals(username) && flatmate.getPassword().equals(password)) {
                            setLoggedInUser(snapshot2.getKey());
                            setFlatUsed(snapshot1.getKey());
                            return;

                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void setLoggedInUser(String flatmate) {
        this.flatmateID = flatmate;

    }

    @Override
    public void setFlatUsed(String flat) {
        this.flatID = flat;

    }


    @Override
    public void AddExpense(Expense expense) {
        myref.child("flats").child(getFlatID()).child("expenses").push().setValue(expense);

    }


    @Override
    public double getExpensesPaidByFlatmate() {
        double value = 0;
        ArrayList<Expense> expenses = new ArrayList<>();
        myref.child("flats").child(getFlatID()).child("expenses").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                expenses.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    expenses.add(snapshot1.getValue(Expense.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting events error", error.getDetails());
            }
        });
        for (Expense money : expenses) {
            if (money.getBuyer().equals(flatmateID)) {
                value += money.getPrice();
            }
        }
        return value;

    }

    @Override
    public void AddChore(Chore chore) {
        myref.child("flats").child(getFlatID()).child("chores").child(chore.getChoreID()).setValue(chore);
    }

    @Override
    public void deleteChore(String ChoreID) {
        myref.child("flats").child(getFlatID()).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    System.out.println(snapshot1);
                    if (snapshot1.getKey().equals(ChoreID)) {
                        snapshot1.getRef().setValue(null);
                        return;
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });
    }

    @Override
    public void AssignChore(String ChoreID) {
        myref.child("flats").child(getFlatID()).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    System.out.println(snapshot1);
                    if (snapshot1.getKey().equals(ChoreID)) {
                        snapshot1.child("assignedto").getRef().setValue(getFlatmateID());
                        return;
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });

    }

    @Override
    public ArrayList<Chore> getChoresNotAssigned() {
        ArrayList<Chore> chores = new ArrayList<>();
        myref.child("flats").child(getFlatID()).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chores.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    if (snapshot1.getValue(Chore.class).getAssignedto().equals("")) {
                        chores.add(snapshot1.getValue(Chore.class));
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });
        return chores;
    }

    @Override
    public ArrayList<Chore> getChoresByFlatmate() {

        ArrayList<Chore> chores = new ArrayList<>();
        myref.child("flats").child(getFlatID()).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chores.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    if (snapshot1.child("assignedto").getValue().equals(getFlatmateID())) {
                        chores.add(snapshot1.getValue(Chore.class));
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });
        return chores;
    }

    @Override
    public void OrganizeEvent(Event event) {
        myref.child("flats").child(getFlatID()).child("events").push().setValue(event);
    }

    @Override
    public String getFlatmateNameByID() {
        final String[] name = {""};
        myref.child("flats").child(getFlatID()).child("tenants").child(getFlatmateID()).child("username").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name[0] = snapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return name[0];

    }

    @Override
    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<>();
        myref.child("flats").child(getFlatID()).child("messages").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                messages.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    messages.add(snapshot1.getValue(String.class));
                    System.out.println(snapshot1.getValue(String.class));
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return messages;
    }

    @Override
    public void sendMessage(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        myref.child("flats").child(getFlatID()).child("messages").push().setValue(dtf.format(now)+": "+message);
    }

    @Override
    public String getCity() {
        return flat.getCity();
    }

    @Override
    public String getCountry() {
        return flat.getCountry();
    }

    @Override
    public String getAddress() {
        return flat.getAddress();
    }

    @Override
    public ArrayList<Flatmate> getTenants() {
        return flat.getTenants();
    }


    @Override
    public ArrayList<Event> getEvents() {
        ArrayList<Event> events = new ArrayList<>();
        myref.child("flats").child(getFlatID()).child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                events.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    events.add(snapshot1.getValue(Event.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting events error", error.getDetails());
            }
        });
        return events;
    }

    @Override
    public ArrayList<Chore> getChores() {
        return flat.getChores();
    }

    @Override
    public ArrayList<Expense> getExpensesByLoggedInFlatmate() {
        ArrayList<Expense> expenses = new ArrayList<>();

        /*myref.child("flats").child(getFlatID()).child("expenses").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                expenses.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Expense expense = snapshot1.getValue(Expense.class);
                    expenses.add(expense);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting expenses error", error.getDetails());
            }
        });
        System.out.println(expenses);*/
        return expenses;
    }

    public String getFlatID() {
        return flatID;
    }

    public String getFlatmateID() {
        return flatmateID;
    }
}
