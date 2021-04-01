package com.jamborpal.app.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private String mText;

    public HomeViewModel() {
        mText = "This is Home Fragment";
    }

    public String getText() {
        return mText;
    }
}