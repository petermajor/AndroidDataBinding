package com.petermajor.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginViewModel extends BaseObservable {

    private String username;
    private String password;

    private Button.OnClickListener loginCommand;

    public LoginViewModel(){
        loginCommand = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("db", String.format("username=%s;password=%s", username, password));
            }
        };
    }

    @Bindable
    public String getUsername() {
        return this.username;
    }

    @Bindable
    public String getPassword() {
        return this.password;
    }

    public Button.OnClickListener getLoginCommand() { return loginCommand; }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(com.petermajor.databinding.BR.username);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(com.petermajor.databinding.BR.password);
    }
}