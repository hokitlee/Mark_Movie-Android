package com.limitip.mm.mark_movie.Model.modelImp;

import android.databinding.Bindable;
import android.view.View;

import com.limitip.mm.mark_movie.Model.MovieModel;
import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.base.BaseObserver;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.service.movie.MovieService;
import com.limitip.mm.mark_movie.viewmodel.MovieVM;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieModelImpl implements MovieModel {
    @Override
    public void getNowShowMovie(final BaseLoadListener<DoubanMovie> loadListener) {
        MovieService.movieService.getNowShowMovie("movie_premium_r")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<DoubanMovie>() {
                    @Override
                    public void onNext(DoubanMovie doubanMovie) {
                        loadListener.LoadSuccess(doubanMovie);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        super.onError(throwable);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });


    }

    @Override
    public void getComingSoonMovie(final BaseLoadListener<DoubanMovie> loadListener) {
        MovieService.movieService.getComingSoonMovie("movie_premium_r")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<DoubanMovie>() {
                    @Override
                    public void onNext(DoubanMovie doubanMovie) {
                        loadListener.LoadSuccess(doubanMovie);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        super.onError(throwable);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });


    }

    @Override
    public void getTop250Movie(final BaseLoadListener<DoubanMovie> loadListener) {
        MovieService.movieService.getTop250Movie("movie_premium_r")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<DoubanMovie>() {
                    @Override
                    public void onNext(DoubanMovie doubanMovie) {
                        loadListener.LoadSuccess(doubanMovie);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        super.onError(throwable);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });

    }

    @Override
    public void getSearchMovie(String search, final BaseLoadListener<DoubanMovie> loadListener) {
        MovieService.movieService.getSearchMovie(search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<DoubanMovie>() {
                    @Override
                    public void onNext(DoubanMovie doubanMovie) {
                        loadListener.LoadSuccess(doubanMovie);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        super.onError(throwable);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });


    }

}
