package com.jamborpal.app.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Expense;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private Model model;

    public HomeViewModel() {
        model = ModelManager.getInstance();
    }

    public ArrayList<Chore> getChoresByUser() {


        return model.getChoresByFlatmate();


    }

    public ArrayList<Expense> getExpenses() {
        return model.getExpensesByLoggedInFlatmate();
    }

    public void delete(String ChoreID) {
        model.deleteChore(ChoreID);


    }
}