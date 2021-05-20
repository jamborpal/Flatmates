package com.jamborpal.app.model;

import androidx.recyclerview.widget.RecyclerView;

public interface Model {
    void getMessages(RecyclerView recyclerView);

    void getChoresByFlatmate(RecyclerView recyclerView);

    void getExpenses(RecyclerView recyclerView);

    void sendMessage(String message);

    boolean login(String username, String password);

    void saveLandLordEmail(String email);

    void saveLandLordPhone(String phone);

    void AddExpense(Expense expense);

    String getFullName();

    String getEmail();

    void AddChore(Chore chore);

    void deleteChore(String ChoreID);

    void AssignChore(String ChoreID);

    void getChoresNotAssigned(RecyclerView recyclerView);


    void OrganizeEvent(Event event);


    String getAddress();

    void getTenants(RecyclerView recyclerView);

    void getEvents(RecyclerView recyclerView);

    void removeProfile();

    void removeFlat();

    void ChangePhone(String phone);

    void ChangeEmail(String email);

    void ChangePassword(String password);

    String getFlatmateID();
}
