package com.limitip.mm.mark_movie.service.movie.movieImpl;

import android.app.Activity;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.limitip.mm.mark_movie.adapter.WantWatchMoviceAdapter;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.pojo.Movie;
import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.util.connectBase.ConnectBase;
import com.limitip.mm.mark_movie.util.Id;
import com.limitip.mm.mark_movie.service.movie.MovieService1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetWantMoviesService1Impl implements MovieService1 {
    private List<Movie> movies = new ArrayList<Movie>();
    private DoubanMovie doubanMovie;
    private Activity activity;

    public GetWantMoviesService1Impl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void getMovice() {
        String url = "movie/findWantWatchMovie.do";
        RequestBody body = new FormBody.Builder()
                .add("id", Id.id)
                .add("token",Id.token)
                .build();
        ConnectBase connectBase = new ConnectBase();
        Call call = connectBase.getPostCall(body, url);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<List<Movie>>() {
                }.getType();
                movies = gson.fromJson(response.body().string(), type);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ListView listView = activity.findViewById(R.id.wantWatchedMoviesLV);
                        Adapter adapter = new WantWatchMoviceAdapter(activity, movies);
                        listView.setAdapter((ListAdapter) adapter);
                    }
                });
            }
        });
    }
}