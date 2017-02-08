package com.spykins.assessment.MainScreen.dagger;


import com.spykins.assessment.MainScreen.mainView.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity target);
}
