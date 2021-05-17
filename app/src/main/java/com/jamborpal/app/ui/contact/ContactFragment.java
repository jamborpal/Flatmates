package com.jamborpal.app.ui.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.jamborpal.app.R;
import com.jamborpal.app.data.DataStorage;
import com.jamborpal.app.data.DataStorageImpl;
import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.ui.home.HomeViewModel;

public class ContactFragment extends Fragment {
    private ContactViewModel contactViewModel;
    private RecyclerView contactList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        contactViewModel =
                new ViewModelProvider(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        contactList = root.findViewById(R.id.rv);
        contactList.hasFixedSize();
        contactList.setLayoutManager(new LinearLayoutManager(getActivity()));
        contactViewModel.getTenants(contactList);
        contactViewModel.giveContext(getContext());
        return root;
    }
}
