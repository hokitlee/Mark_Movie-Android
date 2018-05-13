package com.limitip.mm.mark_movie.viewmodel;

import com.limitip.mm.mark_movie.Model.MovieModel;
import com.limitip.mm.mark_movie.Model.modelImp.MovieModelImpl;
import com.limitip.mm.mark_movie.adapter.MovieAdapter;
import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.databinding.OneBinding;

public class MovieVM {

    public void nowShowMovieVM(final OneBinding binding) {
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getNowShowMovie(new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(resultDoubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(resultDoubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
            }

            @Override
            public void LoadFail(String msg) {

            }
        });
    }

    public void comingSoonMovie(final OneBinding binding) {
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getComingSoonMovie(new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(resultDoubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(resultDoubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
            }

            @Override
            public void LoadFail(String msg) {

            }
        });
    }
    public void top250Movie(final OneBinding binding) {
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getTop250Movie(new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(resultDoubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(resultDoubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
            }

            @Override
            public void LoadFail(String msg) {

            }
        });
    }

    public void searchMovie(String search,final OneBinding binding) {
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getSearchMovie(search,new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {

            }

            @Override
            public void LoadFail(String msg) {

            }
        });
    }
}
