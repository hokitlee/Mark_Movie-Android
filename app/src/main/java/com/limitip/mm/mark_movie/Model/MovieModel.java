package com.limitip.mm.mark_movie.Model;

import android.view.View;

import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.pojo.User;

public interface MovieModel {
    void getNowShowMovie(BaseLoadListener<DoubanMovie> loadListener);
    void getComingSoonMovie(BaseLoadListener<DoubanMovie> loadListener);
    void getTop250Movie(BaseLoadListener<DoubanMovie> loadListener);
    void getSearchMovie(String search,BaseLoadListener<DoubanMovie> loadListener);
}
