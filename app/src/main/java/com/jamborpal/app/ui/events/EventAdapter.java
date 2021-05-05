package com.jamborpal.app.ui.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
private List<Event> eventList;
private EventsViewModel eventsViewModel;
    public EventAdapter(){
        this.eventsViewModel = new EventsViewModel();
        eventList = eventsViewModel.getEvents();
    }
    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.singleevent,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        holder.title.setText(eventList.get(position).getTitle());
        holder.organizer.setText(eventList.get(position).getOrganiser());
        holder.desc.setText(eventList.get(position).getDescription());
        holder.time.setText(eventList.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        TextView organizer;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.event_name);
            time = itemView.findViewById(R.id.event_time);
            organizer= itemView.findViewById(R.id.organizer_name);
            desc= itemView.findViewById(R.id.event_description);
        }
    }
}
