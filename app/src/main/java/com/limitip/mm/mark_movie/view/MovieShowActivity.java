package com.limitip.mm.mark_movie.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.databinding.ActivityMovieShowBinding;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.viewmodel.MovieVM;
import com.squareup.picasso.Picasso;

public class MovieShowActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMovieShowBinding binding;
    private MovieVM movieVM = new MovieVM();
    private DoubanMovie.DoubanSubjects subjects;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_show);
        initialize();
    }

    private void initialize() {
        binding.seen.setOnClickListener(this);
        binding.wantSee.setOnClickListener(this);
        binding.delete.setOnClickListener(this);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        subjects = (DoubanMovie.DoubanSubjects) intent.getSerializableExtra("movie");
        binding.setMovie(subjects);
        Picasso
                .with(this)
                .load(subjects.getImages().getLarge())
                .into(binding.apiMovieImg);
        binding.seen.isEnabled();
        status = intent.getIntExtra("show", 1);
        if (status == 0) {
            binding.delete.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wantSee:
                movieVM.addMyMovie(subjects, 1, binding);
                break;
            case R.id.seen:
                movieVM.addMyMovie(subjects, 2, binding);
                break;
            case R.id.delete:
                movieVM.deleteMyWantMovie(status,subjects,binding);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
