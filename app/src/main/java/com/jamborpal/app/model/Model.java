package com.jamborpal.app.model;

import java.util.ArrayList;

public interface Model {
    void setLoggedInUser(Flatmate flatmate);
    void setFlatUsed(Flat flat);
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

    void MarkEventFinished(int EventID);
    Flatmate getLoggedInUser();
     String getCity();

     String getCountry();

     String getAddress();

     ArrayList<Flatmate> getTenants();


     ArrayList<Event> getEvents();

     ArrayList<Chore> getChores();

     ArrayList<Expense> getExpenses();
}
