package com.jamborpal.app.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Chore;

import java.util.ArrayList;
import java.util.List;

public class OwnChoresAdapter extends RecyclerView.Adapter<OwnChoresAdapter.ViewHolder> {

    private List<Chore> chores;
    private HomeViewModel homeViewModel;

    public OwnChoresAdapter() {
        homeViewModel = new HomeViewModel();
        chores = new ArrayList<>();
    }

    @NonNull
    @Override
    public OwnChoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singleownchore, parent, false);
        chores = homeViewModel.getChoresByUser();
        return new OwnChoresAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull OwnChoresAdapter.ViewHolder holder, int position) {
        holder.done.setOnClickListener(v -> homeViewModel.delete(chores.get(position).getChoreID()));
    }

    @Override
    public int getItemCount() {
        return chores.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        Button done;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.task_nameown);
            desc = itemView.findViewById(R.id.task_descown);
            done = itemView.findViewById(R.id.accept_taskown);
        }
    }
}

