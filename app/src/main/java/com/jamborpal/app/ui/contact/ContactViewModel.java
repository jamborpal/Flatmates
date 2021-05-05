package com.jamborpal.app.ui.contact;

import android.content.Intent;
import android.net.Uri;

import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.ArrayList;

public class ContactViewModel extends ViewModel {
    private String mtext;
    Model model;

    public ContactViewModel() {
        mtext = "This is the Contacts";
        model = ModelManager.getInstance();
    }

    public String getText() {
        return mtext;
    }

    public ArrayList<Flatmate> getTenants() {
        return model.getTenants();
    }


}
