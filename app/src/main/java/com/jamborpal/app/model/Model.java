package com.jamborpal.app.model;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public interface Model {
    void getMessages(RecyclerView recyclerView);
    void getChoresByFlatmate(RecyclerView recyclerView);
    void getExpenses(RecyclerView recyclerView);

    void sendMessage(String message);
    void login(String username, String password);

    void setLoggedInUser(String flatmate);

    void setFlatUsed(String flat);


    void AddExpense(Expense expense);


    double getExpensesPaidByFlatmate();

    void AddChore(Chore chore);

    void deleteChore(String ChoreID);

    void AssignChore(String ChoreID);

    ArrayList<Chore> getChoresNotAssigned();



    void OrganizeEvent(Event event);

    String getFlatmateNameByID();



    String getCity();

    String getCountry();

    String getAddress();

    ArrayList<Flatmate> getTenants();


    ArrayList<Event> getEvents();

    ArrayList<Chore> getChores();

    ArrayList<Expense> getExpensesByLoggedInFlatmate();

    public String getFlatID();

    public String getFlatmateID();
}
