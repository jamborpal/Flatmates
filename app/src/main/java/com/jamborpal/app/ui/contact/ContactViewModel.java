package com.jamborpal.app.ui.contact;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.jamborpal.app.data.DataStorage;
import com.jamborpal.app.data.DataStorageImpl;
import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

import java.util.ArrayList;

public class ContactViewModel extends ViewModel {
    Model model;
    private DataStorage dataStorage;

    public ContactViewModel() {
        model = ModelManager.getInstance();

        dataStorage = new DataStorageImpl();
    }


    public void getTenants(RecyclerView recyclerView) {
         model.getTenants(recyclerView);
    }
    public void giveContext(Context context){
        dataStorage.giveContext(context);
    }


}
