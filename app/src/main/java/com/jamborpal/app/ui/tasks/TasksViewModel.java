package com.jamborpal.app.ui.tasks;

import androidx.lifecycle.ViewModel;

public class TasksViewModel extends ViewModel { private String mtext;

    public TasksViewModel() {
        mtext = "This is the tasks fragment";
    }

    public String getText() {
        return mtext;
    }
}
