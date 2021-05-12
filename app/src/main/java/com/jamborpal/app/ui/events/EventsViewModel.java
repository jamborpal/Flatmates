package com.jamborpal.app.ui.events;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.model.Event;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.List;

public class EventsViewModel extends ViewModel {
    private Model model;

    public EventsViewModel() {
        this.model = ModelManager.getInstance();
    }

    public void AddEvent(Event event) {
        model.OrganizeEvent(event);
    }
    public String getLoggedInUser(){
        return "model.getFlatmateNameByID()";
    }
    public void getEvents(RecyclerView recyclerView){
         model.getEvents(recyclerView);
    }

}
