package com.spykins.assessment.MainScreen.model;

import java.util.ArrayList;
import java.util.List;

public class FavMovie {

    public String posterPath;
    public Boolean adult;
    public String overview;
    public String releaseDate;
    //public List<Integer> genreIds = null;
    public Integer id;
    public String originalTitle;
    public String originalLanguage;
    public String title;
    public String backdropPath;
    public Float popularity;
    public Integer voteCount;
    public Boolean video;
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
