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


}
