package com.spykins.assessment.MainScreen.detailScreen.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spykins.assessment.MainScreen.mainView.view.MainActivity;
import com.spykins.assessment.MainScreen.model.FavMovie;
import com.spykins.assessment.R;

public class DetailActivity extends AppCompatActivity {
    private static String overview = "overview";
    private static String rating = "rating";
    private static String title = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public static Intent newInstance(MainActivity context, FavMovie movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(overview, movie.overview);
        intent.putExtra(rating, movie.voteAverage);
        intent.putExtra(title, movie.title);
        return intent;
    }
}
