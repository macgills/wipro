package com.weather.wipro.myapplication;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by Jack on 08/03/2017.
 */

public class WiProApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
