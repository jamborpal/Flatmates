package com.jamborpal.app.ui.messageboard;

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

public class MessageBoardFragment extends Fragment { private MessageBoardViewModel messageBoardViewModel;
    RecyclerView messageList;
    MessageAdapter messageAdapter;
    private EditText message;
    Button send;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        messageBoardViewModel = new ViewModelProvider(this).get(MessageBoardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_messageboard, container, false);

        messageList = root.findViewById(R.id.rm);
        messageList.hasFixedSize();
        messageList.setLayoutManager(new LinearLayoutManager(getActivity()));

        messageAdapter = new MessageAdapter();
        messageList.setAdapter(messageAdapter);

        message = root.findViewById(R.id.type_message);
        send = root.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageBoardViewModel.sendMessage(message.getText().toString());
                message.setText("");
            }
        });
        return root;
    }
}
