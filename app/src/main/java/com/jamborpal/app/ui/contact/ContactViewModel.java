package com.jamborpal.app.ui.contact;

import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {
    private String mtext;

    public ContactViewModel() {
        mtext = "This is the Contacts";
    }

    public String getText() {
        return mtext;
    }
}
