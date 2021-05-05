package com.jamborpal.app.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.R;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {
    private ProfileViewModel profileViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView fullname = root.findViewById(R.id.profile_fullname1);
        fullname.setText(profileViewModel.getname().fullname);
        return root;
    }

}
