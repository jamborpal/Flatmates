package com.jamborpal.app.model;

public class Event {
    public String title;
    public String description;
    public String time;
    public int organiser;
    public int eventid;
public Event(){

}
    public Event(String title, String description, String time, int organiser) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.organiser = organiser;
        this.eventid = (int) (System.currentTimeMillis() & 0xfffffff);
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

    public int getOrganiser() {
        return organiser;
    }

    public void setOrganiser(int organiser) {
        this.organiser = organiser;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }
}
