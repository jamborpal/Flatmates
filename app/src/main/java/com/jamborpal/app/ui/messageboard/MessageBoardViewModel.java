package com.jamborpal.app.ui.messageboard;

import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.ArrayList;

public class MessageBoardViewModel extends ViewModel {
    private Model model;

    public MessageBoardViewModel() {
        model = ModelManager.getInstance();
    }

    public ArrayList<String> getMessages() {
        return model.getMessages();
    }
    public void sendMessage(String message){
        model.sendMessage(message);
    }

}
