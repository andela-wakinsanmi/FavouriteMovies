package com.spykins.assessment.MainScreen.mainView.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.spykins.assessment.MainScreen.MovieApp;
import com.spykins.assessment.MainScreen.detailScreen.view.DetailActivity;
import com.spykins.assessment.MainScreen.model.FavMovie;
import com.spykins.assessment.MainScreen.mainView.adapter.RecyclerViewAdapter;
import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.R;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @Inject MainActivityContract.Presenter presenter;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MovieApp)getApplication()).getAppComponent().inject(this);
        setUpRecyclerView();
        presenter.setView(this);
        presenter.fetchData();
    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void displayDataInView(List<FavMovie> body) {
        recyclerViewAdapter.swapList(body);
    }

    @Override
    public void onRecyclerItemClicked(FavMovie movie) {
        presenter.recyclerItemIsClicked(movie);
    }

    @Override
    public void navigateToDetailView(FavMovie movie) {
        Intent intent = DetailActivity.newInstance(MainActivity.this, movie);
        startActivity(intent);
        //Go to detail view
    }

    @Override
    public void displayError(String s) {
        Toast.makeText(this,"Problem occured while fetching data",Toast.LENGTH_LONG).show();
    }
}
