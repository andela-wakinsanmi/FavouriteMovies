package com.spykins.assessment.MainScreen.mainView.presenter;


import com.spykins.assessment.MainScreen.http.DataFetcher;
import com.spykins.assessment.MainScreen.model.FavMovie;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.MainScreen.model.ApiResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityPresenter implements MainActivityContract.Presenter {
    private String api_key= "9a928f01255bbe816cdaa0c5473b8c62";
    private String language = "en-US";
    private String sort_by = "popularity.desc";

    private MainActivityContract.View view;
    private DataFetcher dataFetcher;

    @Inject public MainActivityPresenter(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    @Override
    public void setView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchData() {
        dataFetcher.groupList(api_key,language, sort_by)
        .enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
                    view.displayDataInView(apiResponse.results);
                } else {
                    view.displayError("Problem occured from Api");
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                view.displayError("Problem occured from Api");
            }
        });
    }

    @Override
    public void recyclerItemIsClicked(FavMovie movie) {
        view.navigateToDetailView(movie);
    }
}
