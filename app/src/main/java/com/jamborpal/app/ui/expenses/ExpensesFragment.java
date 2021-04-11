package com.jamborpal.app.ui.expenses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.R;
import com.jamborpal.app.ui.profile.ProfileViewModel;

public class ExpensesFragment extends Fragment {
    private ExpensesViewModel expensesViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        expensesViewModel =
                new ViewModelProvider(this).get(ExpensesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_expenses, container, false);
        final TextView textView = root.findViewById(R.id.text_expenses);
        textView.setText(expensesViewModel.getText());
        return root;
    }
}
