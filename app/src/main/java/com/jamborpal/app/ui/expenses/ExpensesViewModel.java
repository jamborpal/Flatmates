package com.jamborpal.app.ui.expenses;

import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Expense;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

public class ExpensesViewModel extends ViewModel {
    private Model model;

    public ExpensesViewModel() {
        this.model = ModelManager.getInstance();
    }

    public String getCurrentUserID() {
       return model.getFlatmateID();
    }
    public void AddExpense(Expense expense){
        model.AddExpense(expense);

    }
}
