package com.spykins.assessment.MainScreen.mainView.contract;


import com.spykins.assessment.MainScreen.http.FavMovie;

import java.util.List;

public interface MainActivityContract {
    interface View {
        void displayDataInView(List<FavMovie> body);
        void onRecyclerItemClicked(FavMovie movie);
        void navigateToDetailView(FavMovie movie);
    }

    interface Presenter {

        void setView(MainActivityContract.View view);
        void fetchData();
        void recyclerItemIsClicked(FavMovie movie);
    }
}
