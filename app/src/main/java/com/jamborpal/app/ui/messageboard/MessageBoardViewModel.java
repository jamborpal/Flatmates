package com.jamborpal.app.ui.messageboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.jamborpal.app.R;
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
