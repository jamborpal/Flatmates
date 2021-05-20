package com.jamborpal.app.data;

import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Event;
import com.jamborpal.app.model.Expense;

public interface DataStorage {
    boolean retrieveUser(String username, String password);

    void addExpense(Expense expense);

    void addChore(Chore chore);

    void addEvent(Event event);

    void addMessage(String message);

    void deleteChore(String ChoreID);

    void deleteEvent(String title, String description);

    void removeFlatmate(String username);

    void removeProfile();

    void removeFlat();

    String getFlatmateID();

    String getAddress();

    void assignChore(String choreID);

    void getChoresNotAssigned(RecyclerView recyclerView);

    void getChoresByFlatmate(RecyclerView recyclerView);

    void getExpenses(RecyclerView recyclerView);

    void getMessages(RecyclerView recyclerView);

    void getTenants(RecyclerView recyclerView);

    void getEvents(RecyclerView recyclerView);

    void setPhone(String phone);

    void setEmail(String email);

    void setPassword(String password);

    void saveLandLordEmail(String email);

    void saveLandLordPhone(String phone);


}
