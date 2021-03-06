package com.spykins.assessment.MainScreen.dagger;

import com.spykins.assessment.MainScreen.http.DataFetcher;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.MainScreen.mainView.presenter.MainActivityPresenter;
import com.spykins.assessment.MainScreen.mainView.view.MainActivity;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    String url = "https://api.themoviedb.org/";

    @Provides
    public DataFetcher provideDataFetcher(Retrofit retrofit) {
        return retrofit.create(DataFetcher.class);
    }

    @Provides
    public OkHttpClient.Builder provideOkHttpLogger() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient.Builder okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }

    @Provides
    public MainActivityContract.Presenter provideMainActivityPresenter(DataFetcher dataFetcher) {
        return new MainActivityPresenter(dataFetcher);
    }

}
