package com.petermajor.databinding;

import android.view.View;

public abstract class Command implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        onExecute();
    }

    public abstract void onExecute();
}
