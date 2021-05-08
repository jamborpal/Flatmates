package com.jamborpal.app.ui.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Expense;


import java.util.ArrayList;
import java.util.List;

public class CostAdapter extends RecyclerView.Adapter<CostAdapter.ViewHolder> {

    private List<Expense> expenses;
    private HomeViewModel homeViewModel;

    public CostAdapter() {
        homeViewModel = new HomeViewModel();
        expenses = homeViewModel.getExpenses();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singelexpense, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.expenseName.setText(expenses.get(position).title);
        holder.expenseCost.setText("" + expenses.get(position).price);
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView expenseName;
        TextView expenseCost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expenseCost = itemView.findViewById(R.id.expense_cost);
            expenseName = itemView.findViewById(R.id.expense_name);
        }
    }
}
