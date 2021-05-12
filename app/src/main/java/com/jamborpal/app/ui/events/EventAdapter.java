package com.jamborpal.app.ui.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.model.Event;

import java.util.List;

public class EventAdapter  {


   public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        TextView organizer;
        TextView desc;
        Button delete;

       public TextView getTitle() {
           return title;
       }

       public TextView getTime() {
           return time;
       }

       public TextView getOrganizer() {
           return organizer;
       }

       public TextView getDesc() {
           return desc;
       }

       public Button getDelete() {
           return delete;
       }

       public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.event_name);
            time = itemView.findViewById(R.id.event_time);
            organizer= itemView.findViewById(R.id.organizer_name);
            desc= itemView.findViewById(R.id.event_description);
            delete = itemView.findViewById(R.id.delete_event);
        }
    }
}
