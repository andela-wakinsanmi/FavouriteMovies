package com.spykins.assessment.MainScreen.dagger;


import com.spykins.assessment.MainScreen.mainView.view.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity target);
}
