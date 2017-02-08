package com.spykins.assessment.MainScreen.mainView.contract;


public interface MainActivityContract {
    public interface View {

    }

    interface Presenter {

        void setView();
        void fetchData();
    }
}
