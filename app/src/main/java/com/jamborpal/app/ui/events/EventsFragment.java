package com.jamborpal.app.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Event;
import com.jamborpal.app.ui.takemehome.TakeMeHomeViewModel;

public class EventsFragment extends Fragment {
    private EventsViewModel eventsViewModel;
    private EditText title;
    private EditText description;
    private EditText time;
    private RecyclerView eventList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        eventsViewModel = new ViewModelProvider(this).get(EventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_events, container, false);

        //initializing EditText attributes

        this.title = root.findViewById(R.id.event_title);
        this.description = root.findViewById(R.id.event_desc);
        this.time = root.findViewById(R.id.event_t);
        //initializing button
        final Button organize = root.findViewById(R.id.add_event);
        organize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getText().toString().isEmpty() && !description.getText().toString().isEmpty() && !time.getText().toString().isEmpty()) {
                    AddEvent();
                    Toast.makeText(getContext(), "Event successfully added", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getContext(), "Don't forget to fill out all the fields!", Toast.LENGTH_SHORT).show();
            }
        });
        //setting up the recycle view part
        eventList = root.findViewById(R.id.rve);
        eventList.hasFixedSize();
        eventList.setLayoutManager(new LinearLayoutManager(getActivity()));
        eventsViewModel.getEvents(eventList);
        return root;
    }

    public void AddEvent() {
        Event event = new Event(title.getText().toString(), description.getText().toString(), time.getText().toString());
        title.setText("");
        description.setText("");
        time.setText("");
        eventsViewModel.AddEvent(event);
    }
}
