package com.spykins.assessment.MainScreen.detailScreen.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.spykins.assessment.MainScreen.mainView.view.MainActivity;
import com.spykins.assessment.MainScreen.model.FavMovie;
import com.spykins.assessment.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private static String overview = "overview";
    private static String rating = "rating";
    private static String title = "title";
    private static String image = "image";
    private String baseUrl = "https://image.tmdb.org/t/p/w500/";

    private ImageView imageView;
    private TextView detailTitle;
    private TextView detailRating;
    private TextView detailOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = (ImageView) findViewById(R.id.detailImageView);
        detailTitle = (TextView) findViewById(R.id.detailTitle);
        detailRating = (TextView) findViewById(R.id.detailRating);
        detailOverview = (TextView) findViewById(R.id.detailOverview);

        Intent intent = getIntent();
        detailTitle.setText(intent.getStringExtra(title));
        String ratingText = "vote_average : " + intent.getFloatExtra(rating, 0.0f);
        detailRating.setText(ratingText);
        detailOverview.setText(intent.getStringExtra(overview));
        String endImageUrl = intent.getStringExtra(image);
        if(endImageUrl != null && !endImageUrl.isEmpty()) {
            Picasso.with(this)
                    .load(baseUrl + endImageUrl)
                    .resize(200, 200)
                    .centerCrop()
                    .into(imageView);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public static Intent newInstance(MainActivity context, FavMovie movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(overview, movie.overview);
        intent.putExtra(rating, movie.voteAverage);
        intent.putExtra(title, movie.title);
        intent.putExtra(image, movie.posterPath);

        return intent;
    }
}
