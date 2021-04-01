package com.jamborpal.app.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private String mText;

    public ProfileViewModel() {
        mText = "This is Profile Fragment";
    }

    public String getText() {
        return mText;
    }
}
