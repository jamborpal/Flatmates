package com.jamborpal.app.model;

public class Chore {
    public int choreid;
    public String title;
    public String description;
    public boolean isdone;
    public int assignedto;
public Chore(){

}
    public Chore(String title, String description) {
        this.title = title;
        this.description = description;
        this.choreid = (int) (System.currentTimeMillis() & 0xfffffff);
        this.isdone = false;
        this.assignedto = 0;
    }

    public Chore(String title) {
        this.title = title;
        this.description = "";
        this.choreid = (int) (System.currentTimeMillis() & 0xfffffff);
        this.isdone = false;
        this.assignedto = 0;
    }

    public int getChoreid() {
        return choreid;
    }

    public void setChoreid(int choreid) {
        this.choreid = choreid;
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

    public int getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(int assignedto) {
        this.assignedto = assignedto;
    }
}
