package com.spykins.assessment.MainScreen.dagger;

import com.spykins.assessment.MainScreen.http.DataFetcher;

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


}
