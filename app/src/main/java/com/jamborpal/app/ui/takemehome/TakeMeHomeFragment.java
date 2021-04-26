package com.jamborpal.app.ui.takemehome;

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

import com.jamborpal.app.R;
import com.jamborpal.app.ui.takemehome.TakeMeHomeViewModel;

public class TakeMeHomeFragment extends Fragment {
    private TakeMeHomeViewModel takeMeHomeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        takeMeHomeViewModel = new ViewModelProvider(this).get(TakeMeHomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_takemehome, container, false);


        return root;
    }
}
