package com.spykins.assessment.MainScreen.mainView.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spykins.assessment.MainScreen.model.FavMovie;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MovieViewHolder> {

    private List<FavMovie> favMovies;
    private MainActivityContract.View view;
    private LayoutInflater inflater;
    private String baseUrl = "https://image.tmdb.org/t/p/w500/";

    public RecyclerViewAdapter(MainActivityContract.View view) {
        favMovies = new ArrayList<>();
        this.view = view;
        inflater = (LayoutInflater)((Context)view).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        LinearLayout root = holder.root;
        final FavMovie favMovie = favMovies.get(position);

        if(favMovie != null) {
            holder.titleTextView.setText(favMovie.title);
           // int pictureDimens = (Context)view).getResources().getDimension(R.dimen.tutorial_cross_marginTop);
            if(favMovie.posterPath != null && !favMovie.posterPath.isEmpty()) {
                Log.d("wale", ""+ baseUrl + favMovie.posterPath);
                Picasso.with((Context)view)
                        .load(baseUrl + favMovie.posterPath)
                        .resize(50, 50)
                        .centerCrop()
                        .into(holder.posterImageView);
            }
        }


        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.onRecyclerItemClicked(favMovie);
            }
        });

    }

    public void swapList(List<FavMovie> favMovies) {
        this.favMovies = favMovies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return favMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public ImageView posterImageView;
        public LinearLayout root;

        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.movieTitle);
            posterImageView = (ImageView) itemView.findViewById(R.id.imagePosterDim);
            root = (LinearLayout) itemView.findViewById(R.id.recyclerItemRoot);
        }
    }
}
