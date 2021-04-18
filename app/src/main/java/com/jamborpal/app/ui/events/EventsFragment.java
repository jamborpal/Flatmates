package com.jamborpal.app.ui.events;

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

public class EventsFragment extends Fragment { private EventsViewModel eventsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        eventsViewModel = new ViewModelProvider(this).get(EventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_events, container, false);


        return root;
    }
}
