package com.jamborpal.app.ui.events;

import androidx.lifecycle.ViewModel;

public class EventsViewModel extends ViewModel { private String mtext;

    public EventsViewModel() {
        mtext = "This is the events FRAGMENT";
    }

    public String getText() {
        return mtext;
    }
}
