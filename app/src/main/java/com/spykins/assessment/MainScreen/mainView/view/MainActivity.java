package com.spykins.assessment.MainScreen.mainView.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spykins.assessment.MainScreen.mainView.contract.MainActivityContract;
import com.spykins.assessment.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @Inject MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.setView();

    }
}
