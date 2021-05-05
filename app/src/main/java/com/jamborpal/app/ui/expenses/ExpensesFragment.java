package com.jamborpal.app.ui.expenses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Expense;

public class ExpensesFragment extends Fragment {
    private ExpensesViewModel expensesViewModel;
    private EditText title;
    private EditText description;
    private EditText expens;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        expensesViewModel =
                new ViewModelProvider(this).get(ExpensesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_expenses, container, false);
        //initializing the edittext
        this.title = root.findViewById(R.id.expense_title);
        this.description = root.findViewById(R.id.expense_description);
        this.expens = root.findViewById(R.id.expense_price);
        final Button addExpense = root.findViewById(R.id.add_expense);
        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewExpense();
            }
        });
        return root;
    }

    private void addNewExpense() {

        Expense expense = new Expense(title.getText().toString(), description.getText().toString(), Double.parseDouble(expens.getText().toString()), expensesViewModel.getCurrentUserID());
        expensesViewModel.AddExpense(expense);
        title.setText("");
        description.setText("");
        expens.setText("");
    }

}
