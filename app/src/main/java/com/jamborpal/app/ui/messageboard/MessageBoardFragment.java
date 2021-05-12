package com.jamborpal.app.ui.messageboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.jamborpal.app.R;

public class MessageBoardFragment extends Fragment {
    private MessageBoardViewModel messageBoardViewModel;
    RecyclerView messageList;
    private EditText message;
    Button send;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        messageBoardViewModel = new ViewModelProvider(this).get(MessageBoardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_messageboard, container, false);

        messageList = root.findViewById(R.id.rm);
        messageList.hasFixedSize();
        messageList.setLayoutManager(new LinearLayoutManager(getActivity()));


        message = root.findViewById(R.id.type_message);
        send = root.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!message.getText().toString().isEmpty()) {
                    messageBoardViewModel.sendMessage(message.getText().toString());
                    message.setText("");
                }


            }
        });
        messageBoardViewModel.getMessages(messageList);

        return root;
    }
}
