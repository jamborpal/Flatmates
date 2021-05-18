package com.jamborpal.app.model;

import java.io.Serializable;

public class Flatmate implements Serializable {
    public int flatmateid;
    public String fullname;
    public String email;
    public String username;
    public String password;
    public String phonenumber;
    public double moneyspent;

    public Flatmate() {

    }

    public Flatmate(int flatmateid, String fullname, String email, String username, String password, String phonenumber, double moneyspent) {
        this.flatmateid = flatmateid;
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.moneyspent = moneyspent;
    }

    public int getFlatmateid() {
        return flatmateid;
    }

    public void setFlatmateid(int flatmateid) {
        this.flatmateid = flatmateid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public double getMoneyspent() {
        return moneyspent;
    }

    public void setMoneyspent(double moneyspent) {
        this.moneyspent = moneyspent;
    }

    public Flatmate(String fullName, String email, String username, String password, String phoneNumber) {
        this.fullname = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.flatmateid = (int) (System.currentTimeMillis() & 0xfffffff);
        this.moneyspent = 0;
        this.phonenumber = phoneNumber;
    }


}
