package com.jamborpal.app.model;

import androidx.recyclerview.widget.RecyclerView;

public interface Model {
    void getMessages(RecyclerView recyclerView);

    void getChoresByFlatmate(RecyclerView recyclerView);

    void getExpenses(RecyclerView recyclerView);

    void sendMessage(String message);

    void login(String username, String password);


    void AddExpense(Expense expense);

    String getFullName();

    String getEmail();

    String getPhoneNumber();

    String getExpensesPaidByFlatmate();

    void AddChore(Chore chore);

    void deleteChore(String ChoreID);

    void AssignChore(String ChoreID);

    void getChoresNotAssigned(RecyclerView recyclerView);


    void OrganizeEvent(Event event);


    String getCity();

    String getCountry();

    String getAddress();

    void getTenants(RecyclerView recyclerView);


    void getEvents(RecyclerView recyclerView);
    void deleteEvent(String title, String description);


    public String getFlatmateID();
}
