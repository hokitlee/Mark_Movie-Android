package com.limitip.mm.mark_movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * User: hokitlee
 * Date: 2018/4/17
 * Time: 21:26
 * Description: toolbar 搜索框Adapter
 */
public class ApiSearchMovieAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private DoubanMovie doubanMovie;
    private Context context;
    private ArrayList<String> genres;

    public ApiSearchMovieAdapter(Context context,DoubanMovie doubanMovie) {
        this.mInflater = LayoutInflater.from(context);
        this.doubanMovie = doubanMovie;
        this.context = context;
    }
    @Override
    public int getCount() {
        return doubanMovie.getSubjects().size();
    }

    @Override
    public Object getItem(int position) {
        return doubanMovie.getSubjects().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ApiViewHolder apiViewHolder;
        if (convertView == null){
            apiViewHolder= new ApiViewHolder();
            convertView = mInflater.inflate(R.layout.api_movie_listview, null);
            apiViewHolder.apiMovieImg = convertView.findViewById(R.id.apiMovieImg);
            apiViewHolder.apiMovieNmae = convertView.findViewById(R.id.apiMovieNmae);
            apiViewHolder.apiMovieType1 = convertView.findViewById(R.id.apiMovieType1);
            apiViewHolder.apiMovieType2 = convertView.findViewById(R.id.apiMovieType2);
            apiViewHolder.apiMovieTime = convertView.findViewById(R.id.apiMovieTime);
            convertView.setTag(apiViewHolder);
        }else{
            apiViewHolder = (ApiViewHolder) convertView.getTag();
        }
        Picasso
                .with(context)
                .load(doubanMovie.getSubjects().get(position).getImages().getSmall())
                .fit()
                .into(apiViewHolder.apiMovieImg);
        apiViewHolder.apiMovieNmae.setText(doubanMovie.getSubjects().get(position).getTitle());
        genres = doubanMovie.getSubjects().get(position).getGenres();
        if(genres.size() >= 1){
            apiViewHolder.apiMovieType1.setText(genres.get(0));
        }
        if (genres.size() >= 2){
            apiViewHolder.apiMovieType2.setText(doubanMovie.getSubjects().get(position).getGenres().get(1));
        }
        apiViewHolder.apiMovieTime.setText(doubanMovie.getSubjects().get(position).getYear());
        return convertView;
    }

    static class ApiViewHolder {
        ImageView apiMovieImg;
        TextView apiMovieNmae;
        TextView apiMovieType1;
        TextView apiMovieType2;
        TextView apiMovieTime;
    }
}

