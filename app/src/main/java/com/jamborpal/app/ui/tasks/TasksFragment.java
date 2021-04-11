package com.jamborpal.app.ui.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.R;
import com.jamborpal.app.ui.takemehome.TakeMeHomeViewModel;

public class TasksFragment extends Fragment { private TasksViewModel tasksViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasksViewModel = new ViewModelProvider(this).get(TasksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tasks, container, false);
        TextView textView = root.findViewById(R.id.text_task);
        textView.setText(tasksViewModel.getText());

        return root;
    }
}
