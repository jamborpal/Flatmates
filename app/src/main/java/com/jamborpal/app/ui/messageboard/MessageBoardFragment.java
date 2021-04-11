package com.jamborpal.app.ui.messageboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.R;
import com.jamborpal.app.ui.takemehome.TakeMeHomeViewModel;

public class MessageBoardFragment extends Fragment { private MessageBoardViewModel messageBoardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        messageBoardViewModel = new ViewModelProvider(this).get(MessageBoardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_messageboard, container, false);
        TextView textView = root.findViewById(R.id.text_messageboard);
        textView.setText(messageBoardViewModel.getText());

        return root;
    }
}
