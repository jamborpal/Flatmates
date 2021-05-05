package com.jamborpal.app.model;

import java.util.ArrayList;

public interface Model {
    void setLoggedInUser(String flatmate);
    void setFlatUsed(String flat);
    void MoveIn(Flatmate flatmate);

    void MoveOut(int FlatmateID);

    void AddExpense(Expense expense);

    ArrayList<Expense> getExpensesByFlatmate(int FlatmateID);

    double getExpensesPaidByFlatmate(int FlatmateID);

    void AddChore(Chore chore);

    void MarkChoreDone(int ChoreID);

    void AssignChore(int ChoreID, int FlatmateID);
    ArrayList<Chore> getChoresNotAssigned();

    ArrayList<Chore> getChoresByFlatmate(int FlatmateID);

    void OrganizeEvent(Event event);
    String getFlatmateNameByID();

    void MarkEventFinished(int EventID);
    Flatmate getLoggedInUser();
     String getCity();

     String getCountry();

     String getAddress();

     ArrayList<Flatmate> getTenants();


     ArrayList<Event> getEvents();

     ArrayList<Chore> getChores();

     ArrayList<Expense> getExpenses();
    public String getFlatID();

    public String getFlatmateID();
}
