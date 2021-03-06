package com.petermajor.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextWatcher;
import android.util.Log;

public class LoginViewModel extends BaseObservable {

    private String username;
    private String password;
    private boolean isInNotification = false;

    private Command loginCommand;

    public LoginViewModel(){
        loginCommand = new Command() {
            @Override
            public void onExecute() {
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

    public Command getLoginCommand() { return loginCommand; }

    public void setUsername(String username) {
        this.username = username;

        if (!isInNotification)
            notifyPropertyChanged(com.petermajor.databinding.BR.username);
    }

    public void setPassword(String password) {
        this.password = password;

        if (!isInNotification)
            notifyPropertyChanged(com.petermajor.databinding.BR.password);
    }

    @Bindable
    public TextWatcher getOnUsernameChanged() {

        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(String newValue) {
                isInNotification = true;
                setUsername(newValue);
                isInNotification = false;
            }
        };
    }

    @Bindable
    public TextWatcher getOnPasswordChanged() {

        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(String newValue) {
                isInNotification = true;
                setPassword(newValue);
                isInNotification = false;
            }
        };
    }
//    @BindingAdapter("bind:onTextChanged")
//    public static void setOnTextChanged(EditText view, final OnTextChanged changed) {
//
//        TextWatcher watcher = new TextWatcher() {
//
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            public void afterTextChanged(Editable s) {
//                changed.onTextChanged(s.toString());
//            }
//        };
//
//        view.addTextChangedListener(watcher);
//    }
}