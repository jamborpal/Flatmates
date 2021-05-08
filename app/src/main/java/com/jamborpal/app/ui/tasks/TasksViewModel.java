package com.jamborpal.app.ui.tasks;

import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.ArrayList;

public class TasksViewModel extends ViewModel {
    private Model model;

    public TasksViewModel() {
        model = ModelManager.getInstance();

    }


    public void addTask(Chore task) {
        model.AddChore(task);

    }
    public ArrayList<Chore> getAllNotAssignedChores(){
        return  model.getChoresNotAssigned();
    }
    public void accept(String title, String description){
        model.AssignChore(title,description);
    }
    public void delete(String title,String description){
        model.deleteChore(title,description);
    }
}
