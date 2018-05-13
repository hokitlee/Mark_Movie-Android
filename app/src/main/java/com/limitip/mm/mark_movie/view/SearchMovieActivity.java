package com.limitip.mm.mark_movie.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.service.movie.movieImpl.GetApiSearchMovieService1Impl;

public class SearchMovieActivity extends AppCompatActivity implements View.OnClickListener{

    private View rootView;
    private Activity activity;
    private GetApiSearchMovieService1Impl movieService;
    private Toolbar toolbar;
    private LayoutInflater inflater;
    private SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        activity = this;
        initView();
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        movieService = new GetApiSearchMovieService1Impl(activity,getIntent().getStringExtra("searchContext"));
        movieService.getMovice();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                activity.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
