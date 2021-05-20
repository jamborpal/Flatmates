package com.jamborpal.app.ui.login;

import androidx.lifecycle.ViewModel;

import com.jamborpal.app.model.Model;
import com.jamborpal.app.model.ModelManager;

public class LoginViewModel extends ViewModel {
    private Model model;
    public LoginViewModel() {
        this.model = ModelManager.getInstance();
    }

    public boolean login(String username,String password) {
          return model.login(username, password);
    }


}
