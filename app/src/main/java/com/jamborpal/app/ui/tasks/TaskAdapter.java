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


public class TaskAdapter {



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TasksViewModel tasksViewModel;

        public TextView getTitle() {
            return title;
        }

        public TextView getDescription() {
            return description;
        }

        public Button getAccept() {
            return accept;
        }

        public Button getDelete() {
            return delete;
        }

        Button accept;
        Button delete;

        public ViewHolder(View itemView) {
            super(itemView);
            tasksViewModel = new TasksViewModel();
            title = itemView.findViewById(R.id.task_name);
            description = itemView.findViewById(R.id.task_desc);
            accept = itemView.findViewById(R.id.accept_task);
            delete = itemView.findViewById(R.id.remove_task);
           // accept.setOnClickListener(v -> tasksViewModel.accept());

            //delete.setOnClickListener(v -> tasksViewModel.delete());

        }
    }
}
