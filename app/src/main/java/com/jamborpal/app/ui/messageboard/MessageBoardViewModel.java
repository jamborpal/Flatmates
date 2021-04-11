package com.jamborpal.app.ui.messageboard;

import androidx.lifecycle.ViewModel;

public class MessageBoardViewModel extends ViewModel { private String mtext;

    public MessageBoardViewModel() {
        mtext = "This is the message board FRAGMENT";
    }

    public String getText() {
        return mtext;
    }
}
