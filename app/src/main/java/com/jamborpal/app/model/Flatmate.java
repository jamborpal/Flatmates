package com.jamborpal.app.model;

public class Flatmate {
    public int FlatmateID;
    public String FullName;
    public String email;
    public String username;
    public String password;
    public int PhoneNumber;
    public double MoneySpent;

    public Flatmate(String fullName, String email, String username, String password) {
        FullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.FlatmateID = (int) (System.currentTimeMillis() & 0xfffffff);
        this.MoneySpent = 0;
        this.PhoneNumber = 0;
    }

    public int getFlatmateID() {
        return FlatmateID;
    }


    public String getFullName() {
        return FullName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public double getMoneySpent() {
        return MoneySpent;
    }

    public void addMoneySpent(double moneySpent) {
        MoneySpent += moneySpent;
    }
}
