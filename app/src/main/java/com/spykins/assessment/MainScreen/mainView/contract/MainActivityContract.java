package com.spykins.assessment.MainScreen.mainView.contract;


import com.spykins.assessment.MainScreen.model.FavMovie;

import java.util.List;

public interface MainActivityContract {
    interface View {
        void displayDataInView(List<FavMovie> body);
        void onRecyclerItemClicked(FavMovie movie);
        void navigateToDetailView(FavMovie movie);
        void displayError(String s);
    }

    interface Presenter {
        void setView(MainActivityContract.View view);
        void fetchData();
        void recyclerItemIsClicked(FavMovie movie);
    }
}
