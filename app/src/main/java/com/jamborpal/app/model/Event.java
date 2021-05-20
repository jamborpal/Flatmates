package com.jamborpal.app.model;

public class Event {
    public String title;
    public String description;
    public String time;
    public String organiser;

    public Event() {

    }

    public Event(String title, String description, String time, String organiser) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.organiser = organiser;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

}
