package com.limitip.mm.mark_movie.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.databinding.ActivitySearchMovieBinding;
import com.limitip.mm.mark_movie.viewmodel.MovieVM;


public class SearchMovieActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySearchMovieBinding binding;
    private View rootView;
    private Activity activity;
    private MovieVM movieVM = new MovieVM();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search_movie);
        activity = this;
        initView();
    }

    private void initView(){
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        movieVM.searchMovie(getIntent().getStringExtra("searchText"),binding);
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
