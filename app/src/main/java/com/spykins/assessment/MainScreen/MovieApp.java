package com.spykins.assessment.MainScreen;


import android.app.Application;

import com.spykins.assessment.MainScreen.dagger.AppComponent;
import com.spykins.assessment.MainScreen.dagger.AppModule;
import com.spykins.assessment.MainScreen.dagger.DaggerAppComponent;

public class MovieApp extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
