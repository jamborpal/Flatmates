package com.jamborpal.app.model;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ModelManager implements Model {
    //Add variable of database instance
    public Flatmate LoggedInUser;
    public Flat flat;
    private FirebaseDatabase database;

    public ModelManager(Flatmate loggedInUser) {
        LoggedInUser = loggedInUser;
    }

    public ModelManager() {
        LoggedInUser = new Flatmate();
        database = FirebaseDatabase.getInstance();
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
    public void setLoggedInUser(Flatmate flatmate) {
        this.LoggedInUser = flatmate;
    }

    @Override
    public void setFlatUsed(Flat flat) {
        this.flat = flat;
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
        flat.AddExpense(expense);
    }

    @Override
    public ArrayList<Expense> getExpensesByFlatmate(int FlatmateID) {
        return flat.getExpensesByFlatmate(FlatmateID);
    }

    @Override
    public double getExpensesPaidByFlatmate(int FlatmateID) {
        return flat.getExpensesPaidByFlatmate(FlatmateID);
    }

    @Override
    public void AddChore(Chore chore) {
        flat.AddChore(chore);
    }

    @Override
    public void MarkChoreDone(int ChoreID) {
        flat.MarkChoreDone(ChoreID);
    }

    @Override
    public void AssignChore(int ChoreID, int FlatmateID) {
        flat.AssignChore(ChoreID, FlatmateID);
    }

    @Override
    public ArrayList<Chore> getChoresNotAssigned() {
        return flat.getNotAssignedChores();
    }

    @Override
    public ArrayList<Chore> getChoresByFlatmate(int FlatmateID) {
        return flat.getChoresByFlatmate(FlatmateID);
    }

    @Override
    public void OrganizeEvent(Event event) {
        flat.OrganizeEvent(event);
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
        return flat.getEvents();
    }

    @Override
    public ArrayList<Chore> getChores() {
        return flat.getChores();
    }

    @Override
    public ArrayList<Expense> getExpenses() {
        return flat.getExpenses();
    }

    public Flatmate getLoggedInUser() {
        return LoggedInUser;
    }

    public Flat getFlat() {
        return flat;
    }

}
