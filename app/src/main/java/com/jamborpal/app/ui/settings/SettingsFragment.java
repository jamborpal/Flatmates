package com.jamborpal.app.ui.settings;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.MainActivity;
import com.jamborpal.app.R;
import com.jamborpal.app.login.LoginHandler;
import com.jamborpal.app.ui.home.HomeViewModel;

public class SettingsFragment extends Fragment {
    private SettingsViewModel settingsViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        Logout(root);
        return root;
    }

    public void Logout(View v) {
        final Button logout = v.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginHandler.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }


}
