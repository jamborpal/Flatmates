package com.jamborpal.app.model;

public class Expense {
    public String Title;
    public String Description;
    public double Price;
    public int Buyer;
    public int ExpenseID;

    public Expense(String title, String description, double price, int buyer) {
        Title = title;
        Description = description;
        Price = price;
        Buyer = buyer;
        ExpenseID = (int) (System.currentTimeMillis() & 0xfffffff);
    }

    public Expense(String title, double price, int buyer) {
        Title = title;
        Price = price;
        Buyer = buyer;
        ExpenseID = (int) (System.currentTimeMillis() & 0xfffffff);
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrice() {
        return Price;
    }


    public int getBuyer() {
        return Buyer;
    }

    public int getExpenseID() {
        return ExpenseID;
    }
}
