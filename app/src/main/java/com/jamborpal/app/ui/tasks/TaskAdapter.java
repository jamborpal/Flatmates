package com.jamborpal.app.ui.tasks;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.jamborpal.app.R;
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

        }
    }
}
