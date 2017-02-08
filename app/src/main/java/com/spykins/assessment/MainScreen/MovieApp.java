package com.spykins.assessment.MainScreen;


import android.app.Application;

import com.spykins.assessment.MainScreen.dagger.AppComponent;

public class MovieApp extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        //appComponent = DaggerAppComponent
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
