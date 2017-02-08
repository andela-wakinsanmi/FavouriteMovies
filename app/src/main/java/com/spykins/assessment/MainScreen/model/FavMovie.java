package com.spykins.assessment.MainScreen.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FavMovie {

    @SerializedName("poster_path")
    public String posterPath;
    public Boolean adult;
    public String overview;
    @SerializedName("release_date")
    public String releaseDate;
    @SerializedName("genre_ids")
    public List<Integer> genreIds = null;
    public Integer id;
    @SerializedName("original_title")
    public String originalTitle;
    @SerializedName("original_language")
    public String originalLanguage;
    public String title;
    @SerializedName("backdrop_path")
    public String backdropPath;
    public Float popularity;
    @SerializedName("vote_count")
    public Integer voteCount;
    public Boolean video;
    @SerializedName("vote_average")
    public Float voteAverage;

    public String toString() {
        return " posterPath : " + posterPath +
                " adult : " + adult +
                " overview : " + overview +
                " releaseDate : " + releaseDate +
                " id : " + id +
                " originalTitle : " + originalTitle +
                " originalLanguage : " + originalLanguage +
                " title : " + title +
                " backdropPath : " + backdropPath +
                " popularity : " + popularity +
                " voteCount : " + voteCount +
                " video : " + video +
                " voteAverage : " + voteAverage;
    }
}
