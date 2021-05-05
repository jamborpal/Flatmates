package com.jamborpal.app.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Flat implements Serializable {

    public String flatID;


    public String city;
    public String country;
    public String address;
    public ArrayList<Flatmate> tenants;
    public ArrayList<Event> events;
    public ArrayList<Chore> chores;
    public ArrayList<Expense> expenses;

    public Flat() {

    }

    public Flat(String flatID, String city, String country, String address) {
        this.city = city;
        this.country = country;
        this.address = address;
        this.flatID = flatID;
        this.chores = new ArrayList<>();
        this.events = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.tenants = new ArrayList<>();

    }

    /*Moving*/
    public void MoveIn(Flatmate flatmate) {
        tenants.add(flatmate);
    }

    public void MoveOut(int FlatmateID) {
        for (int i = 0; i < tenants.size(); i++) {
            if (tenants.get(i).getFlatmateid() == FlatmateID) {
                tenants.remove(i);
            }
        }

    }

    /*Handling expenses*/
    public void AddExpense(Expense expense) {
        expenses.add(expense);
    }

    public double getAllExpenses() {
        double all = 0;
        for (int i = 0; i < expenses.size(); i++) {
            all += expenses.get(i).getPrice();
        }
        return all;
    }

    public ArrayList<Expense> getExpensesByFlatmate(int FlatmateID) {
        ArrayList<Expense> expenses = new ArrayList<>();
        /*for (int i = 0; i < this.expenses.size(); i++) {
            if (this.expenses.get(i).getBuyer() == FlatmateID) {
                expenses.add(this.expenses.get(i));
            }
        }*/
        return expenses;
    }

    public double getExpensesPaidByFlatmate(int FlatmateID) {
        double expenses = 0;
       /* for (int i = 0; i < this.expenses.size(); i++) {
            if (this.expenses.get(i).getBuyer() == FlatmateID) {
                expenses += (this.expenses.get(i).getPrice());
            }
        }*/
        return expenses;
    }

    /*Handling chore*/
    public void AddChore(Chore chore) {
        chores.add(chore);

    }

    public void MarkChoreDone(int ChoreID) {
        for (int i = 0; i < chores.size(); i++) {
            if (chores.get(i).getChoreid() == ChoreID) {
                chores.get(i).setIsdone(true);
            }
        }
    }

    public void AssignChore(int ChoreID, int FlatmateID) {
        for (int i = 0; i < chores.size(); i++) {
            if (chores.get(i).getChoreid() == ChoreID) {
                chores.get(i).setAssignedto(FlatmateID);
            }
        }
    }

    public ArrayList<Chore> getChoresByFlatmate(int FlatmateID) {
        ArrayList<Chore> chores = new ArrayList<>();
        for (int i = 0; i < this.chores.size(); i++) {
            if (this.chores.get(i).getAssignedto() == FlatmateID) {
                chores.add(this.chores.get(i));
            }
        }
        return chores;
    }

    public ArrayList<Chore> getNotAssignedChores() {
        ArrayList<Chore> chores = new ArrayList<>();
        for (int i = 0; i < this.chores.size(); i++) {
            if (this.chores.get(i).getAssignedto() == 0) {
                chores.add(this.chores.get(i));
            }
        }
        return chores;
    }

    /*Handling events*/
    public void OrganizeEvent(Event event) {
        events.add(event);
    }

    public void MarkEventFinished(int EventID) {
       /* for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventid() == EventID) {
                events.remove(i);
            }
        }*/
    }


    /*Getters*/

    public String getFlatID() {
        return flatID;
    }

    public void setFlatID(String flatID) {
        this.flatID = flatID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Flatmate> getTenants() {
        return tenants;
    }

    public void setTenants(ArrayList<Flatmate> tenants) {
        this.tenants = tenants;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Chore> getChores() {
        return chores;
    }

    public void setChores(ArrayList<Chore> chores) {
        this.chores = chores;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
}
