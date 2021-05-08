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

    private HomeViewModel homeViewModel;
    RecyclerView latestCosts;
    CostAdapter costAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        latestCosts = root.findViewById(R.id.rvlatestexpenses);
        latestCosts.hasFixedSize();
        latestCosts.setLayoutManager(new LinearLayoutManager(getActivity()));

        costAdapter = new CostAdapter();
        latestCosts.setAdapter(costAdapter);

        return root;
    }
}