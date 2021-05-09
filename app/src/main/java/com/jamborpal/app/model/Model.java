package com.jamborpal.app.model;

import java.util.ArrayList;

public interface Model {
     void login(String username, String password);
    void setLoggedInUser(String flatmate);

    void setFlatUsed(String flat);


    void AddExpense(Expense expense);


    double getExpensesPaidByFlatmate();

    void AddChore(Chore chore);
    void deleteChore(String ChoreID);

    void AssignChore(String ChoreID);

    ArrayList<Chore> getChoresNotAssigned();

    ArrayList<Chore> getChoresByFlatmate();

    void OrganizeEvent(Event event);

    String getFlatmateNameByID();
ArrayList<String> getMessages();
void sendMessage(String message);

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
