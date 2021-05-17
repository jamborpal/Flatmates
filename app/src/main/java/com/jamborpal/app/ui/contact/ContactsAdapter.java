package com.jamborpal.app.ui.contact;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;
import com.jamborpal.app.login.LoginHandler;

import java.util.ArrayList;


public class ContactsAdapter {
   public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phoneNumber;
        TextView email;
        TextView moneySpent;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rv_item_name);
            email = itemView.findViewById(R.id.contact_email);
            moneySpent = itemView.findViewById(R.id.moneyspent);
            phoneNumber = itemView.findViewById(R.id.contact_number);


        }

       public TextView getMoneySpent() {
           return moneySpent;
       }

       public TextView getName() {
           return name;
       }

       public TextView getPhoneNumber() {
           return phoneNumber;
       }

       public TextView getEmail() {
           return email;
       }
   }
}
