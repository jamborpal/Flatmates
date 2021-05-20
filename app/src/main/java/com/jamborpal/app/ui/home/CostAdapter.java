package com.jamborpal.app.ui.home;



import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
public class CostAdapter{


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView expenseName;

        public TextView getExpenseName() {
            return expenseName;
        }

        public TextView getExpenseCost() {
            return expenseCost;
        }

        TextView expenseCost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expenseCost = itemView.findViewById(R.id.expense_cost);
            expenseName = itemView.findViewById(R.id.expense_name);
        }
    }
}
