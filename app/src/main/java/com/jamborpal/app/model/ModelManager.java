package com.jamborpal.app.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ModelManager implements Model {
    //Add variable of database instance
    public Flatmate LoggedInUser;
    public Flat flat;
    public String flatID;
    public String flatmateID;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private static ModelManager modelManager;

    public synchronized static ModelManager getInstance() {
        if (modelManager == null) {
            modelManager = new ModelManager();
        }
        return modelManager;
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
        myref.child("flats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
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
    public void MoveIn(Flatmate flatmate) {
        flat.MoveIn(flatmate);
    }

    @Override
    public void MoveOut(int FlatmateID) {
        flat.MoveOut(FlatmateID);
    }

    @Override
    public void AddExpense(Expense expense) {
        myref.child("flats").child(getFlatID()).child("expenses").push().setValue(expense);

    }

    @Override
    public ArrayList<Expense> getExpensesByFlatmate(int FlatmateID) {
        return flat.getExpensesByFlatmate(FlatmateID);
    }

    @Override
    public double getExpensesPaidByFlatmate() {
        double value = 0;
        ArrayList<Expense> expenses = new ArrayList<>();
        myref.child("flats").child(flatID).child("expenses").addValueEventListener(new ValueEventListener() {
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
        myref.child("flats").child(flatID).child("chores").addValueEventListener(new ValueEventListener() {
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
        myref.child("flats").child(flatID).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    System.out.println(snapshot1);
                    if (snapshot1.getKey().equals(ChoreID)) {
                        snapshot1.child("assignedto").getRef().setValue(flatmateID);
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
        myref.child("flats").child(flatID).child("chores").addValueEventListener(new ValueEventListener() {
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
        myref.child("flats").child("hi").child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chores.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    if (snapshot1.getValue(Chore.class).getAssignedto().equals(flatmateID)) {
                        chores.add(snapshot1.getValue(Chore.class));
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });
        System.out.println(chores);
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
    public void MarkEventFinished(int EventID) {
        flat.MarkEventFinished(EventID);
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
        myref.child("flats").child(flatID).child("events").addValueEventListener(new ValueEventListener() {
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
        Expense expense = new Expense("fsdfds","dfsd",2131,"dfs");
        expenses.add(expense);
            /*myref.child("flats").child("hi").child("expenses").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    expenses.clear();
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        Expense expense =new Expense(snapshot1.child("title").getValue().toString(),Double.parseDouble(snapshot1.child("price").getValue().toString()),snapshot1.child("buyer").getValue().toString());
                        expenses.add(expense);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e("Getting expenses error", error.getDetails());
                }
            });*/
        System.out.println(expenses);
        return expenses;
    }

    public Flatmate getLoggedInUser() {
        return LoggedInUser;
    }

    public Flat getFlat() {
        return flat;
    }

    public String getFlatID() {
        return flatID;
    }

    public String getFlatmateID() {
        return flatmateID;
    }
}
