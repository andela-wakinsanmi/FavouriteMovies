package com.spykins.assessment.MainScreen.http;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataFetcher {
    /*@GET("/3/discover/movie?api_key={apiKey}&language=en-US&sort_by=popularity.desc")
    List<Movie> getMovies();*/


    @GET("/3/discover/movie")
    Call<List<FavMovie>> groupList(@Query("api_key") String apiKey,
                                   @Query("language") String language, @Query("sort_by") String sortBy);
    //api key = 9a928f01255bbe816cdaa0c5473b8c62
}
