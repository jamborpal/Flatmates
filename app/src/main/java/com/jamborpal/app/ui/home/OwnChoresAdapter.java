package com.jamborpal.app.ui.home;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;

public class OwnChoresAdapter {

    public static  class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;

        public TextView getTitle() {
            return title;
        }

        public TextView getDesc() {
            return desc;
        }

        public Button getDone() {
            return done;
        }

        Button done;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.task_nameown);
            desc = itemView.findViewById(R.id.task_descown);
            done = itemView.findViewById(R.id.accept_taskown);
        }
    }
}

