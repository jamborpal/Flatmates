package com.jamborpal.app.ui.tasks;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

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
    public void getAllNotAssignedChores(RecyclerView recyclerView){
        model.getChoresNotAssigned(recyclerView);
    }
    public void accept(String ChoreID){
        model.AssignChore(ChoreID);
    }
    public void delete(String ChoreID){
        model.deleteChore(ChoreID);


    }
}
