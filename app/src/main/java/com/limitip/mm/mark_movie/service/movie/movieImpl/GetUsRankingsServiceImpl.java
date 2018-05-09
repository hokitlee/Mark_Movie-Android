package com.limitip.mm.mark_movie.service.movie.movieImpl;

import android.app.Activity;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.adapter.ApiMoiveAdapter;
import com.limitip.mm.mark_movie.connectBase.ConnectBase;
import com.limitip.mm.mark_movie.connectBase.Id;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.service.movie.MovieService;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GetUsRankingsServiceImpl implements MovieService {
    private DoubanMovie doubanMovie;
    private Activity activity;

    public GetUsRankingsServiceImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void getMovice() {

        String url = "/v2/movie/us_box?"
                +"id="+ Id.id
                +"&&token="+ Id.token;;
        ConnectBase connectBase = new ConnectBase();
        Call call = connectBase.getGetCall(url);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<DoubanMovie>() {
                }.getType();
                doubanMovie = gson.fromJson(response.body().string(), type);
                System.out.println(doubanMovie.toString());
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GridView gridView = activity.findViewById(R.id.apiMoiveGridview);
                        Adapter adapter =  new ApiMoiveAdapter(activity,doubanMovie);
                        gridView.setAdapter((ListAdapter) adapter);

                    }
                });
            }
        });
    }
}
