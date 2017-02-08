package com.spykins.assessment.mainscreen;


import com.spykins.assessment.MainScreen.http.DataFetcher;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.MainScreen.mainView.presenter.MainActivityPresenter;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainActivityPresenterTest {

    public MainActivityContract.Presenter presenter;

    @Mock
    public MainActivityContract.View mockView;

    @Mock
    DataFetcher dataFetcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new MainActivityPresenter(dataFetcher);
    }

    public void testPresenterCallsView() {
        presenter.fetchData();
    }


}
