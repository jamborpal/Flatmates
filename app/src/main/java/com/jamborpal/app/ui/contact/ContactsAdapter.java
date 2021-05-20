package com.jamborpal.app.ui.contact;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;


public class ContactsAdapter {
   public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phoneNumber;
        TextView email;
        TextView moneySpent;
        Button kickout;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rv_item_name);
            email = itemView.findViewById(R.id.contact_email);
            moneySpent = itemView.findViewById(R.id.moneyspent);
            phoneNumber = itemView.findViewById(R.id.contact_number);
            kickout = itemView.findViewById(R.id.kick);


        }

       public Button getKickout() {
           return kickout;
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
