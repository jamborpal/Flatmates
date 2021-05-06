package com.jamborpal.app.ui.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Chore;

import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private TasksViewModel tasksViewModel;
    private List<Chore> choreList;

    public TaskAdapter() {
        this.tasksViewModel = new TasksViewModel();
        this.choreList = tasksViewModel.getAllNotAssignedChores();
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singletask, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {

        holder.title.setText(choreList.get(position).getTitle());
        holder.description.setText(choreList.get(position).getDescription());
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasksViewModel.accept(choreList.get(position).getTitle());
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasksViewModel.delete(choreList.get(position).getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return choreList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        Button accept;
        Button delete;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.task_name);
            description = itemView.findViewById(R.id.task_desc);
            accept = itemView.findViewById(R.id.accept_task);
            delete = itemView.findViewById(R.id.remove_task);
        }
    }
}
