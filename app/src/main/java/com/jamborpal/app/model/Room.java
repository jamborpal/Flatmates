package com.jamborpal.app.model;

public class Room {
    public String Name;
    public int RoomID;
    public int Tenant;

    public Room(String Name) {
        this.Name = Name;
        this.RoomID = (int) (System.currentTimeMillis() & 0xfffffff);
        this.Tenant = 0;
    }

    public Room(String Name, int Tenant) {
        this.Name = Name;
        this.RoomID = (int) (System.currentTimeMillis() & 0xfffffff);
        this.Tenant = Tenant;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRoomID() {
        return RoomID;
    }

    public int getTenant() {
        return Tenant;
    }

    public void setTenant(int tenant) {
        Tenant = tenant;
    }
}
