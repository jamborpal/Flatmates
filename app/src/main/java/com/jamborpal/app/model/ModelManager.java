package com.jamborpal.app.model;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.data.DataStorage;
import com.jamborpal.app.data.DataStorageImpl;

public class ModelManager implements Model {
    //Add variable of database instance
    private static ModelManager modelManager;
    private DataStorage database;

    public synchronized static ModelManager getInstance() {
        if (modelManager == null) {
            modelManager = new ModelManager();
        }
        return modelManager;
    }

    public ModelManager(String flatmateID, String flatID) {
        database = new DataStorageImpl();
    }

    public ModelManager() {
        database = new DataStorageImpl();
    }

    @Override
    public String getEmail() {
        return "LoggedInUser.getEmail()";
    }

    @Override
    public String getPhoneNumber() {
        return "LoggedInUser.getPhonenumber()";
    }


    @Override
    public String getExpensesPaidByFlatmate() {
        return "LoggedInUser.getMoneyspent()";
    }

    @Override
    public void login(String username, String password) {

        database.retrieveUser(username, password);
    }


    @Override
    public void AddExpense(Expense expense) {
        database.addExpense(expense);

    }

    @Override
    public String getFullName() {
        return "";
    }


    @Override
    public void AddChore(Chore chore) {
        database.addChore(chore);
    }

    @Override
    public void deleteChore(String ChoreID) {
        database.deleteChore(ChoreID);
    }

    @Override
    public void AssignChore(String ChoreID) {
        database.assignChore(ChoreID);

    }

    @Override
    public void getChoresNotAssigned(RecyclerView recyclerView) {
        database.getChoresNotAssigned(recyclerView);
    }

    @Override
    public void getChoresByFlatmate(RecyclerView recyclerView) {
        database.getChoresByFlatmate(recyclerView);
    }

    @Override
    public void getExpenses(RecyclerView recyclerView) {
        database.getExpenses(recyclerView);
    }

    @Override
    public void OrganizeEvent(Event event) {
        database.addEvent(event);
    }

    @Override
    public void getMessages(RecyclerView recyclerView) {
        database.getMessages(recyclerView);
    }

    @Override
    public void sendMessage(String message) {
        database.addMessage(message);
    }


    @Override
    public String getAddress() {
        return database.getAddress();
    }

    @Override
    public void getTenants(RecyclerView recyclerView) {
        database.getTenants(recyclerView);
    }


    @Override
    public void getEvents(RecyclerView recyclerView) {
        database.getEvents(recyclerView);
    }


    @Override
    public void deleteEvent(String title, String description) {
        database.deleteEvent(title, description);
    }

    @Override
    public void ChangePhone(String phone) {
        database.setPhone(phone);
    }

    @Override
    public void ChangeEmail(String email) {
        database.setEmail(email);
    }

    @Override
    public void ChangePassword(String password) {
        database.setPassword(password);
    }


    public String getFlatmateID() {
        return database.getFlatmateID();
    }
}
