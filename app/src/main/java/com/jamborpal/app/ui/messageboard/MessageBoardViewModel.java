package com.jamborpal.app.ui.messageboard;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.ArrayList;

public class MessageBoardViewModel extends ViewModel {
    private Model model;

    public MessageBoardViewModel() {
        model = ModelManager.getInstance();
    }

    public void getMessages(RecyclerView recyclerView) {
       model.getMessages(recyclerView);
    }

    public void sendMessage(String message) {
        model.sendMessage(message);
    }

}
