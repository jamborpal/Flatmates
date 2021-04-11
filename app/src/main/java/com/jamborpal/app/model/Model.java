package com.jamborpal.app.model;

import java.util.ArrayList;

public interface Model {
    void MoveIn(Flatmate flatmate, int RoomID);

    void MoveOut(int FlatmateID);

    void AddExpense(Expense expense);

    ArrayList<Expense> getExpensesByFlatmate(int FlatmateID);

    double getExpensesPaidByFlatmate(int FlatmateID);

    void AddChore(Chore chore);

    void MarkChoreDone(int ChoreID);

    void AssignChore(int ChoreID, int FlatmateID);

    ArrayList<Chore> getChoresByFlatmate(int FlatmateID);

    void OrganizeEvent(Event event);

    void MarkEventFinished(int EventID);
     String getCity();

     String getCountry();

     String getAddress();

     ArrayList<Flatmate> getTenants();

     ArrayList<Room> getRooms() ;

     ArrayList<Event> getEvents();

     ArrayList<Chore> getChores();

     ArrayList<Expense> getExpenses();
}
