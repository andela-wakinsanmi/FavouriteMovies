package com.spykins.assessment.mainscreen;


import com.spykins.assessment.MainScreen.http.DataFetcher;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.MainScreen.mainView.presenter.MainActivityPresenter;
import com.spykins.assessment.MainScreen.model.ApiResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainActivityPresenterTest {

    MainActivityContract.Presenter presenter;

    @Mock
    public MainActivityContract.View mockView;

    @Mock
    DataFetcher mockDataFetcher;

    @Mock
    public Call<ApiResponse> mockCall;

    @Mock
    public ResponseBody mockResponseBody;

    @Mock
    ApiResponse apiResponse;

    @Captor
    public ArgumentCaptor<Callback<ApiResponse>> argumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new MainActivityPresenter(mockDataFetcher);
        presenter.setView(mockView);
    }


    @Test
    public void fetchDataWasSuccessful() {
        when(mockDataFetcher.groupList(anyString(),anyString(),anyString())).thenReturn(mockCall);
        presenter.fetchData();

        verify(mockCall).enqueue(argumentCaptor.capture());

        Response<ApiResponse> response = Response.success(apiResponse);

        argumentCaptor.getValue().onResponse(mockCall, response);
        verify(mockView).displayDataInView(apiResponse.results);
    }

    @Test
    public void fetchDataUnsuccesful() {
        when(mockDataFetcher.groupList(anyString(),anyString(),anyString())).thenReturn(mockCall);
        Throwable throwable = new Throwable(new RuntimeException());

        presenter.fetchData();

        verify(mockCall).enqueue(argumentCaptor.capture());

        argumentCaptor.getValue().onFailure(mockCall, throwable);
        verify(mockView).displayError("Problem occured from Api");

    }

}
