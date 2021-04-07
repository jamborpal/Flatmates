package com.jamborpal.app.model;

public class Event {
    public String Title;
    public String Description;
    public String Time;
    public int Organiser;
    public int EventID;

    public Event(String title, String description, String time, int organiser) {
        Title = title;
        Description = description;
        Time = time;
        Organiser = organiser;
        this.EventID = (int) (System.currentTimeMillis() & 0xfffffff);
    }

    public String getTitle() {
        return Title;
    }


    public String getDescription() {
        return Description;
    }


    public String getTime() {
        return Time;
    }


    public int getOrganiser() {
        return Organiser;
    }


    public int getEventID() {
        return EventID;
    }

}
