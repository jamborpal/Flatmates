package com.jamborpal.app.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

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

    public void getChoresByUser(RecyclerView recyclerView) {

    model.getChoresByFlatmate(recyclerView, model.getFlatmateID());




    }

    public void getExpenses(RecyclerView recyclerView) {

            model.getExpenses(recyclerView);


    }

    public void delete(String ChoreID) {
        model.deleteChore(ChoreID);


    }
}