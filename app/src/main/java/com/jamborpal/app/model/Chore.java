package com.jamborpal.app.model;

public class Chore {
    public int ChoreID;
    public String Title;
    public String Description;
    public boolean isDone;
    public int AssignedTo;

    public Chore(String Title, String Description) {
        this.Title = Title;
        this.Description = Description;
        this.ChoreID = (int) (System.currentTimeMillis() & 0xfffffff);
        this.isDone = false;
        this.AssignedTo = 0;
    }

    public Chore(String Title) {
        this.Title = Title;
        this.Description = "";
        this.ChoreID = (int) (System.currentTimeMillis() & 0xfffffff);
        this.isDone = false;
        this.AssignedTo = 0;
    }

    public int getChoreID() {
        return ChoreID;
    }

    public String getTitle() {
        return Title;
    }


    public String getDescription() {
        return Description;
    }


    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }

    public int getAssignedTo() {
        return AssignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        AssignedTo = assignedTo;
    }
}
