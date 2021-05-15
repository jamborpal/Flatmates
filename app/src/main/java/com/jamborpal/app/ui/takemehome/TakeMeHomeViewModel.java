package com.jamborpal.app.ui.takemehome;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

public class TakeMeHomeViewModel extends ViewModel {
    private Model model;

    public TakeMeHomeViewModel() {
       model = ModelManager.getInstance();
    }
    public String getAddress(){
        String address= model.getAddress();
        return address;
    }

}
