package com.jamborpal.app.model;

public class Chore {
    public String title;
    public String description;
    public boolean isdone;
    public String choreID;
    public String assignedto;

    public Chore() {

    }

    public Chore(String title, String description) {
        this.title = title;
        this.description = description;
        this.choreID = "" + (System.currentTimeMillis() & 0xfffffff);
        this.isdone = false;
        this.assignedto = "";
    }

    public Chore(String title) {
        this.title = title;
        this.description = "";
        this.isdone = false;
        this.assignedto = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsdone() {
        return isdone;
    }

    public void setIsdone(boolean isdone) {
        this.isdone = isdone;
    }

    public String getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(String assignedto) {
        this.assignedto = assignedto;
    }

    public String getChoreID() {
        return choreID;
    }

    public void setChoreID(String choreID) {
        this.choreID = choreID;
    }
}
