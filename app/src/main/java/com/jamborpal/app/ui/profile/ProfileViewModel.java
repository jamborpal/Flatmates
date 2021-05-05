package com.jamborpal.app.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

public class ProfileViewModel extends ViewModel {
    private Model model;

    public ProfileViewModel() {
        this.model = new ModelManager();

    }

    public Flatmate getname() {
        return model.getLoggedInUser();
    }
}
