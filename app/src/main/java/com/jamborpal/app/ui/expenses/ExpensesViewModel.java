package com.jamborpal.app.ui.expenses;

import androidx.lifecycle.ViewModel;

public class ExpensesViewModel extends ViewModel {
    private String mText;

    public ExpensesViewModel() {
        mText = "This is Expenses Fragment";
    }

    public String getText() {
        return mText;
    }
}
