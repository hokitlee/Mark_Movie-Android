package com.limitip.mm.mark_movie.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.limitip.mm.mark_movie.controller.MovieController;
import com.limitip.mm.mark_movie.R;

public class TwoFragment extends Fragment implements View.OnClickListener {
    private MovieController movieController;
    private Activity activity;
//    private MovieService1 movieService1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two, container, false);
//        movieService1 = new MovieService1();
//        movieService1.getWatchedMovies(activity);
        movieController = new MovieController();
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.watchedMoviesButton:
                movieController.addWatchedMovies(new MovieController.onMovieListener() {
                    @Override
                    public void onComplete() {

                    }
                });
        }
    }
}
