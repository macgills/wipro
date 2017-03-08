package com.weather.wipro.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Jack on 08/03/2017.
 */

class BaseActivity extends AppCompatActivity {
    protected <T extends View> T getViewById(int id) {
        return (T) findViewById(id);
    }
}
