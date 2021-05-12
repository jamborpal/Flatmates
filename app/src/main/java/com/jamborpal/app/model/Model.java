package com.jamborpal.app.model;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public interface Model {
    void getMessages(RecyclerView recyclerView);

    void getChoresByFlatmate(RecyclerView recyclerView, String id);

    void getExpenses(RecyclerView recyclerView);

    void sendMessage(String message);

    void login(String username, String password);

    void setLoggedInUser(String flatmate);

    void setFlatUsed(String flat);


    void AddExpense(Expense expense);

    String getFullName();

    String getEmail();

    String getPhoneNumber();

    String getExpensesPaidByFlatmate();

    void AddChore(Chore chore);

    void deleteChore(String ChoreID);

    void AssignChore(String ChoreID);

    void getChoresNotAssigned(RecyclerView recyclerView);


    void OrganizeEvent(Event event);


    String getCity();

    String getCountry();

    String getAddress();

    ArrayList<Flatmate> getTenants();


    void getEvents(RecyclerView recyclerView);
    void deleteEvent(String title, String description);

    public String getFlatID();

    public String getFlatmateID();
}
