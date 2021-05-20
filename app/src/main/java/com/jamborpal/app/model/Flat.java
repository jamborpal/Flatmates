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
