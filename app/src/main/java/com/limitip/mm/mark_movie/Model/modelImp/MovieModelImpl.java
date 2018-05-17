package com.limitip.mm.mark_movie.Model.modelImp;

import android.widget.Toast;

import com.google.gson.Gson;
import com.limitip.mm.mark_movie.Model.MovieModel;
import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.base.BaseObserver;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.pojo.Message;
import com.limitip.mm.mark_movie.pojo.Subjects;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.service.movie.ApiMovieService;
import com.limitip.mm.mark_movie.service.movie.MyMovieService;
import com.limitip.mm.mark_movie.util.Id;
import com.limitip.mm.mark_movie.util.MyConvert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MovieModelImpl implements MovieModel {
    @Override
    public void getNowShowMovie(final BaseLoadListener<DoubanMovie> loadListener) {
        ApiMovieService.API_MOVIE_SERVICE.getNowShowMovie("movie_premium_r")
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
        ApiMovieService.API_MOVIE_SERVICE.getComingSoonMovie("movie_premium_r")
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
        ApiMovieService.API_MOVIE_SERVICE.getTop250Movie("movie_premium_r")
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
        ApiMovieService.API_MOVIE_SERVICE.getSearchMovie(search)
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
    public void addMyMovie(Subjects subjects, int status, final BaseLoadListener<String> loadListener) {

        MyMovieService.MY_MOVIE_SERVICE.addtMovies(subjects,Id.id,Id.token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Message >(){
                    @Override
                    public void onNext(Message msg) {
                            loadListener.LoadSuccess(msg.getMsg());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        super.onError(throwable);
                        System.out.println("ERROR");
                    }
                });
    }
    public void findMyMovie(RequestBody requestBody,
                            final BaseLoadListener<Map<String,ArrayList>> loadListener){

        MyMovieService.MY_MOVIE_SERVICE.findMyMovie(requestBody,Id.id,Id.token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map>() {
                    @Override
                    public void onNext(Map map) {
                        loadListener.LoadSuccess(map);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        super.onError(throwable);
                    }
                });

    }

    public void deleteMyMovie(RequestBody requestBody,
                              final BaseLoadListener<Message> loadListener){

        MyMovieService.MY_MOVIE_SERVICE.deleteMyMovie(requestBody,Id.id,Id.token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Message>(){
                    @Override
                    public void onNext(Message msg) {
                        loadListener.LoadSuccess(msg);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError");
                    }
                });
    }
}
