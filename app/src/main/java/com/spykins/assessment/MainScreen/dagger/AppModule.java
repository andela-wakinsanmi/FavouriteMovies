package com.spykins.assessment.MainScreen.dagger;

import com.spykins.assessment.MainScreen.http.DataFetcher;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.MainScreen.mainView.presenter.MainActivityPresenter;
import com.spykins.assessment.MainScreen.mainView.view.MainActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    String url = "https://api.themoviedb.org";

    @Provides
    public DataFetcher provideDataFetcher(Retrofit retrofit) {
        return retrofit.create(DataFetcher.class);
    }

    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public MainActivityContract.Presenter provideMainActivityPresenter(DataFetcher dataFetcher) {
        return new MainActivityPresenter(dataFetcher);
    }

}
