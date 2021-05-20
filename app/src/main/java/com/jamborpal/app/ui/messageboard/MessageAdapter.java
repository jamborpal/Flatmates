package com.jamborpal.app.ui.messageboard;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jamborpal.app.R;

public class MessageAdapter{

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView getMessage() {
            return message;
        }

        public TextView message;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);

        }
    }
}
