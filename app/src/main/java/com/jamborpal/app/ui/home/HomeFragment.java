package com.jamborpal.app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.R;

public class HomeFragment extends Fragment {

    RecyclerView latestCosts;
    RecyclerView ownchores;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        latestCosts = root.findViewById(R.id.rvlatestexpenses);
        latestCosts.hasFixedSize();
        latestCosts.setLayoutManager(new LinearLayoutManager(getActivity()));

        ownchores = root.findViewById(R.id.rvowntasks);
        ownchores.hasFixedSize();
        ownchores.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeViewModel.getChoresByUser(ownchores);
        homeViewModel.getExpenses(latestCosts);

        return root;
    }
}