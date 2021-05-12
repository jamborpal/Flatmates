package com.jamborpal.app.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.R;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {
    private ProfileViewModel profileViewModel;
    TextView fullName;
    TextView email;
    TextView phoneNumber;
    TextView moneySpent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        fullName=root.findViewById(R.id.profile_fullname);
        email=root.findViewById(R.id.profile_email);
        phoneNumber=root.findViewById(R.id.profile_phone);
        moneySpent=root.findViewById(R.id.money_spent);
        fullName.setText(profileViewModel.getFullname());
        email.setText(profileViewModel.getEmail());
        phoneNumber.setText(profileViewModel.getPhoneNumber());
        moneySpent.setText(profileViewModel.getMoneySpent());
        final Button edit_number= root.findViewById(R.id.edit_phoneNumber);
        edit_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return root;
    }

}
