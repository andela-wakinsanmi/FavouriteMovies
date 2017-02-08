package com.spykins.assessment.MainScreen.http;

import com.spykins.assessment.MainScreen.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataFetcher {
    @GET("/3/discover/movie")
    Call<ApiResponse> groupList(@Query("api_key") String apiKey,
                                @Query("language") String language,
                                @Query("sort_by") String sortBy);
}
