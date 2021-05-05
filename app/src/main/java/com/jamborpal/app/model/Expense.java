package com.jamborpal.app.model;

public class Expense {
    public String title;
    public String description;
    public double price;
    public String buyer;

    public Expense() {

    }

    public Expense(String title, String description, double price, String buyer) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.buyer = buyer;

    }

    public Expense(String title, double price, String buyer) {
        this.title = title;
        this.price = price;
        this.buyer = buyer;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }


}
