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
        Button call;
        Button email;
        String phoneNumber;
        String emailAddress;
        TextView moneySpent;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rv_item_name);
            call = itemView.findViewById(R.id.contact_call);
            email = itemView.findViewById(R.id.contact_email);
            moneySpent = itemView.findViewById(R.id.moneyspent);
            phoneNumber = "";
            emailAddress = "";

        }

       public TextView getMoneySpent() {
           return moneySpent;
       }

       public TextView getName() {
           return name;
       }

       public Button getCall() {
           return call;
       }

       public Button getEmail() {
           return email;
       }

       public String getPhoneNumber() {
           return phoneNumber;
       }

       public String getEmailAddress() {
           return emailAddress;
       }
   }
}
