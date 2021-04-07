package com.jamborpal.app.model;

import java.util.ArrayList;

public class Flat {
    public String City;
    public String Country;
    public String Address;
    public ArrayList<Flatmate> Tenants;
    public ArrayList<Room> Rooms;
    public ArrayList<Event> Events;
    public ArrayList<Chore> Chores;
    public ArrayList<Expense> Expenses;

    public Flat(String city, String country, String address, ArrayList<Room> Rooms) {
        City = city;
        Country = country;
        Address = address;
        this.Chores = new ArrayList<>();
        this.Events = new ArrayList<>();
        this.Expenses = new ArrayList<>();
        this.Rooms = Rooms;
        this.Tenants = new ArrayList<>();
    }

    /*Moving*/
    public void MoveIn(Flatmate flatmate, int RoomID) {
        Tenants.add(flatmate);
        for (int i = 0; i < Rooms.size(); i++) {
            if (Rooms.get(i).getRoomID() == RoomID) {
                Rooms.get(i).setTenant(flatmate.getFlatmateID());
            }
        }
    }

    public void MoveOut(int FlatmateID) {
        for (int i = 0; i < Tenants.size(); i++) {
            if (Tenants.get(i).getFlatmateID() == FlatmateID) {
                Tenants.remove(i);
            }
        }
        for (int i = 0; i < Rooms.size(); i++) {
            if (Rooms.get(i).getTenant() == FlatmateID) {
                Rooms.get(i).setTenant(0);
            }
        }
    }

    /*Handling expenses*/
    public void AddExpense(Expense expense) {
        Expenses.add(expense);
    }

    public double getAllExpenses() {
        double all = 0;
        for (int i = 0; i < Expenses.size(); i++) {
            all += Expenses.get(i).getPrice();
        }
        return all;
    }

    public ArrayList<Expense> getExpensesByFlatmate(int FlatmateID) {
        ArrayList<Expense> expenses = new ArrayList<>();
        for (int i = 0; i < Expenses.size(); i++) {
            if (Expenses.get(i).getBuyer() == FlatmateID) {
                expenses.add(Expenses.get(i));
            }
        }
        return expenses;
    }

    public double getExpensesPaidByFlatmate(int FlatmateID) {
        double expenses = 0;
        for (int i = 0; i < Expenses.size(); i++) {
            if (Expenses.get(i).getBuyer() == FlatmateID) {
                expenses += (Expenses.get(i).getPrice());
            }
        }
        return expenses;
    }

    /*Handling chore*/
    public void AddChore(Chore chore) {
        Chores.add(chore);
    }

    public void MarkChoreDone(int ChoreID) {
        for (int i = 0; i < Chores.size(); i++) {
            if (Chores.get(i).getChoreID() == ChoreID) {
                Chores.get(i).setDone();
            }
        }
    }

    public void AssignChore(int ChoreID, int FlatmateID) {
        for (int i = 0; i < Chores.size(); i++) {
            if (Chores.get(i).getChoreID() == ChoreID) {
                Chores.get(i).setAssignedTo(FlatmateID);
            }
        }
    }

    public ArrayList<Chore> getChoresByFlatmate(int FlatmateID) {
        ArrayList<Chore> chores = new ArrayList<>();
        for (int i = 0; i < Chores.size(); i++) {
            if (Chores.get(i).getAssignedTo() == FlatmateID) {
                chores.add(Chores.get(i));
            }
        }
        return chores;
    }

    /*Handling events*/
    public void OrganizeEvent(Event event) {
        Events.add(event);
    }

    public void MarkEventFinished(int EventID) {
        for (int i = 0; i < Events.size(); i++) {
            if (Events.get(i).getEventID() == EventID) {
                Events.remove(i);
            }
        }
    }

    /*Getters*/
    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public String getAddress() {
        return Address;
    }

    public ArrayList<Flatmate> getTenants() {
        return Tenants;
    }

    public ArrayList<Room> getRooms() {
        return Rooms;
    }

    public ArrayList<Event> getEvents() {
        return Events;
    }

    public ArrayList<Chore> getChores() {
        return Chores;
    }

    public ArrayList<Expense> getExpenses() {
        return Expenses;
    }


}
