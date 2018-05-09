package com.limitip.mm.mark_movie.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.limitip.mm.mark_movie.pojo.Movie;
import com.limitip.mm.mark_movie.R;

import java.util.List;

/**
 * User: hokitlee
 * Date: 2018/4/11
 * Time: 20:00
 * Description:
 */
public class WatchedMovieAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Movie> movies;

    public WatchedMovieAdapter(Context context, List<Movie> movies) {
        this.mInflater = LayoutInflater.from(context);
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.movie_listview, null);
            viewHolder.img = convertView.findViewById(R.id.img);
            viewHolder.watchedMovieNameTv = convertView.findViewById(R.id.watchedMovieNameTv);
            viewHolder.watchedMovieTypeTv = convertView.findViewById(R.id.watchedMovieTypeTv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Movie movie = movies.get(position);
        viewHolder.img.setImageResource(R.drawable.ic_launcher_background);
        viewHolder.watchedMovieNameTv.setText(movie.getMovieName());
        viewHolder.watchedMovieTypeTv.setText(movie.getMovieType());
        return convertView;
    }

    static class ViewHolder {
        ImageView img;
        TextView watchedMovieNameTv;
        TextView watchedMovieTypeTv;
    }
}