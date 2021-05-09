package com.jamborpal.app.ui.messageboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.jamborpal.app.R;

import java.util.ArrayList;

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
