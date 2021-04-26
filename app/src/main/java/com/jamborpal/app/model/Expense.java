package com.jamborpal.app.model;

public class Expense {
    public String title;
    public String description;
    public double price;
    public int buyer;
    public int expenseid;
public Expense(){

}
    public Expense(String title, String description, double price, int buyer) {
        this.title = title;
       this. description = description;
        this.price = price;
        this.buyer = buyer;
        expenseid = (int) (System.currentTimeMillis() & 0xfffffff);
    }

    public Expense(String title, double price, int buyer) {
        this.title = title;
        this.price = price;
        this.buyer = buyer;
        expenseid = (int) (System.currentTimeMillis() & 0xfffffff);
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

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public int getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(int expenseid) {
        this.expenseid = expenseid;
    }
}
