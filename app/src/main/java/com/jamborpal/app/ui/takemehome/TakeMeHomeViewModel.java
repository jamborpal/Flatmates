package com.jamborpal.app.ui.takemehome;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TakeMeHomeViewModel extends ViewModel {
    private String mtext;

    public TakeMeHomeViewModel() {
        mtext = "This is the TAKE ME HOME FRAGMENT";
    }

    public String getText() {
        return mtext;
    }
}
