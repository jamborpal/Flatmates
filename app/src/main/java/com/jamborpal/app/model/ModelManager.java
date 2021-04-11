package com.jamborpal.app.model;

import java.util.ArrayList;

public class ModelManager implements Model {
    //Add variable of database instance
    private Flatmate LoggedInUser;
    private Flat flat;

    public ModelManager(Flatmate loggedInUser) {
        LoggedInUser = loggedInUser;
    }

    public ModelManager() {
        ArrayList<Room> rooms= new ArrayList<>();
        Room room1 = new Room("Room1");
        Room room2 = new Room("Room2");
        Room room3= new Room("Room3");
        this.flat = new Flat("Horsens", "Denmark", "Radhustorvet", rooms);
        this.LoggedInUser = new Flatmate("Pál Jámbor", "jamborpal@gmail.com", "jamborpal", "1234");
        LoggedInUser.setPhoneNumber(0211313);
        Flatmate flatmate= new Flatmate("Toyota","toyi@gmail.om","toy","1234");
        flatmate.setPhoneNumber(32432432);

    }

    @Override
    public void MoveIn(Flatmate flatmate, int RoomID) {
        flat.MoveIn(flatmate, RoomID);
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
    public ArrayList<Room> getRooms() {
        return flat.getRooms();
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
