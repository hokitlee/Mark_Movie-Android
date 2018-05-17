package com.limitip.mm.mark_movie.Model;

import android.view.View;

import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.pojo.Message;
import com.limitip.mm.mark_movie.pojo.Subjects;
import com.limitip.mm.mark_movie.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;

public interface MovieModel {
    void getNowShowMovie(BaseLoadListener<DoubanMovie> loadListener);
    void getComingSoonMovie(BaseLoadListener<DoubanMovie> loadListener);
    void getTop250Movie(BaseLoadListener<DoubanMovie> loadListener);
    void getSearchMovie(String search,BaseLoadListener<DoubanMovie> loadListener);
    void addMyMovie(Subjects subjects, int status, final BaseLoadListener<String> loadListener);
    void findMyMovie(RequestBody requestBody, final BaseLoadListener<Map<String,ArrayList>> loadListener);
    public void deleteMyMovie(RequestBody requestBody,
                              BaseLoadListener<Message> loadListener);
}
