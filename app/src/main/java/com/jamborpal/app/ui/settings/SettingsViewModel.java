package com.jamborpal.app.ui.settings;

import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {
    private String mtext;

    public SettingsViewModel() {
        mtext = "This is the settings";
    }

    public String getText() {
        return mtext;
    }
}
