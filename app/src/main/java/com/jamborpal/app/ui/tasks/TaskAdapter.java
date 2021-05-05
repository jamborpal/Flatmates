package com.jamborpal.app.ui.tasks;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;
import com.jamborpal.app.ui.contact.ContactsAdapter;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    TasksFragment tasksFragment;
    Model model;

    public TaskAdapter() {
        model = ModelManager.getInstance();
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singletask, parent, false);
        tasksFragment = new TasksFragment();
        ViewHolder holder = new ViewHolder(view);
        holder.Accept(view);
        holder.Delete(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {

        holder.title.setText(model.getChores().get(position).getTitle());
        holder.description.setText(model.getChores().get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return model.getChores().size();
    }

    public void update(ArrayList<Chore> data) {
        model.getChoresNotAssigned().clear();
        model.getChoresNotAssigned().addAll(data);
        notifyDataSetChanged();
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

        public void Accept(View v) {

            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.getChoresNotAssigned().get(getAdapterPosition()).setAssignedto(model.getLoggedInUser().getFlatmateid());

                }
            });
        }

        public void Delete(View v) {

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
