package com.jamborpal.app.ui.settings;

import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

public class SettingsViewModel extends ViewModel {
    private Model model;

    public SettingsViewModel() {
        this.model = ModelManager.getInstance();
    }

    public void SavePhone(String number) {
        model.ChangePhone(number);
    }

    public void SaveEmail(String email) {
        model.ChangeEmail(email);
    }
    public void SavePassword(String password){
        model.ChangePassword(password);
    }
    public void deleteProfile(){
        model.removeProfile();
    }
    public void deleteFlat(){
        model.removeFlat();
    }


}
