package com.jamborpal.app.data;

import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Event;
import com.jamborpal.app.model.Expense;

public interface DataStorage {
    //login
    boolean retrieveUser(String username, String password);

    //adding
    void addExpense(Expense expense);

    void addChore(Chore chore);

    void addEvent(Event event);

    void addMessage(String message);

    //deleting
    void deleteChore(String ChoreID);

    void deleteEvent(String title, String description);

    void removeFlatmate(String username);

    void removeProfile();

    void removeFlat();

    //getters
    String getFlatmateID();

    String getAddress();

    //set chore to a flatmate
    void assignChore(String choreID);

    //get lists to recycleviews
    void getChoresNotAssigned(RecyclerView recyclerView);

    void getChoresByFlatmate(RecyclerView recyclerView);

    void getExpenses(RecyclerView recyclerView);

    void getMessages(RecyclerView recyclerView);

    void getTenants(RecyclerView recyclerView);

    void getEvents(RecyclerView recyclerView);

    //setters
    void setPhone(String phone);

    void setEmail(String email);

    void setPassword(String password);

    void saveLandLordEmail(String email);

    void saveLandLordPhone(String phone);


}
