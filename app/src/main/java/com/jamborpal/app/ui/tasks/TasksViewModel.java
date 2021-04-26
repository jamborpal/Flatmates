package com.jamborpal.app.ui.tasks;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.ArrayList;

public class TasksViewModel extends ViewModel {
    private Model model;

    public TasksViewModel() {
        model = new ModelManager();

    }


    public void addTask(Chore task) {
        model.AddChore(task);

    }
    public ArrayList<Chore> getAllNotAssignedChores(){
        return  model.getChoresNotAssigned();
    }
}
