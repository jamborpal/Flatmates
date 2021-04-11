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


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    ContactFragment contactFragment;
    ArrayList<String> strings;

    public ContactsAdapter() {
        strings = new ArrayList<>();
        strings.add("sfsd");
        strings.add("sfsddfdsafdf");

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.singlecontact, parent, false);
        contactFragment = new ContactFragment();
        ViewHolder holder = new ViewHolder(view);
        holder.Mail(view);
        holder.Call(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.name.setText(contactFragment.getContactViewModel().getTenants().get(position).getFullName());
        holder.name.setText(strings.get(position));
        //holder.emailAddress = contactViewModel.getTenants().get(position).getEmail();
        //holder.phoneNumber = Integer.toString(contactViewModel.getTenants().get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        //return contactFragment.getContactViewModel().getTenants().size();
        return strings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        Button call;
        Button email;
        // String phoneNumber;
        //String emailAddress;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rv_item_name);
            call = itemView.findViewById(R.id.contact_call);
            email = itemView.findViewById(R.id.contact_email);
            // phoneNumber = "";
            // emailAddress = "";
        }

        public void Call(View v) {

            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.e("number", phoneNumber);
                    contactFragment.call("32432");

                }
            });
        }

        public void Mail(View v) {

            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Log.e("email", emailAddress);
                    contactFragment.email("jambo@gmail.com");

                }
            });
        }
    }
}
