package com.jamborpal.app.ui.home;

import android.os.Bundle;
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

import com.jamborpal.app.R;

public class HomeFragment extends Fragment {

    RecyclerView latestCosts;
    CostAdapter costAdapter;
    RecyclerView ownchores;
    OwnChoresAdapter ownChoresAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        latestCosts = root.findViewById(R.id.rvlatestexpenses);
        latestCosts.hasFixedSize();
        latestCosts.setLayoutManager(new LinearLayoutManager(getActivity()));

        ownchores = root.findViewById(R.id.rvowntasks);
        ownchores.hasFixedSize();
        ownchores.setLayoutManager(new LinearLayoutManager(getActivity()));

        ownChoresAdapter = new OwnChoresAdapter();
        ownchores.setAdapter(ownChoresAdapter);

        return root;
    }
}