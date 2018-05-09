package com.limitip.mm.mark_movie.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.service.movie.MovieService;
import com.limitip.mm.mark_movie.service.movie.movieImpl.GetWantMoviesServiceImpl;

public class ThreeFragment extends Fragment {

    private Activity activity;
    private MovieService movieService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.three,container,false);
//        movieService = new GetWantMoviesServiceImpl();
//        movieService.getMovice(activity);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
