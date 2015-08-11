package com.petermajor.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

public class LoginViewModel extends BaseObservable {

    private String username;
    private String password;

//    private Command loginCommand;

    public LoginViewModel(){
//        loginCommand = new Command() {
//            @Override
//            public void onExecute() {
//                Log.d("db", String.format("username=%s;password=%s", username, password));
//            }
//        };
    }

    @Bindable
    public String getUsername() {
        return this.username;
    }

    @Bindable
    public String getPassword() {
        return this.password;
    }

//    public Command getLoginCommand() { return loginCommand; }

    public void onLogin(View view) {
        Log.d("db", String.format("username=%s;password=%s", username, password));
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(com.petermajor.databinding.BR.username);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(com.petermajor.databinding.BR.password);
    }
}