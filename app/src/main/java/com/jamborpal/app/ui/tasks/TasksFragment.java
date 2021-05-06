package com.jamborpal.app.ui.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Chore;

public class TasksFragment extends Fragment {
    private TasksViewModel tasksViewModel;

    private EditText title;
    private EditText description;
    private Chore task;
    private RecyclerView taskList;
    private TaskAdapter taskAdapater;
    Button addTask;

    public TasksFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasksViewModel = new ViewModelProvider(this).get(TasksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tasks, container, false);
        title = root.findViewById(R.id.task_title);
        description = root.findViewById(R.id.task_description);
        taskList = root.findViewById(R.id.rvt);
        taskList.hasFixedSize();
        taskList.setLayoutManager(new LinearLayoutManager(getActivity()));
        taskAdapater = new TaskAdapter();
        taskList.setAdapter(taskAdapater);
        final Button addTask = root.findViewById(R.id.add_task);
        addTask.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                addTask();
            }
        });
        return root;
    }

    public void addTask() {
        Chore chore = new Chore(title.getText().toString(),description.getText().toString());
        tasksViewModel.addTask(chore);
        title.setText("");
        description.setText("");
    }
}
