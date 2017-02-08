package com.spykins.assessment.MainScreen.mainView.presenter;


import com.spykins.assessment.MainScreen.http.DataFetcher;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;

import javax.inject.Inject;


public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private DataFetcher dataFetcher;

    @Inject public MainActivityPresenter(DataFetcher dataFetcher) {

    }
    @Override
    public void setView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchData() {

    }
}
