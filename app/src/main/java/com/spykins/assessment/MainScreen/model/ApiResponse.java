package com.spykins.assessment.MainScreen.model;


import java.util.ArrayList;
import java.util.List;

public class ApiResponse {
    public Integer page;
    public List<FavMovie> results = new ArrayList<>();
    public Integer totalResults;
    public Integer totalPages;

    public String toString() {
        return " page : " + page +
                " results : " + results +
                " totalResults : " + totalResults +
                " totalPages : " + totalPages;
    }
}
