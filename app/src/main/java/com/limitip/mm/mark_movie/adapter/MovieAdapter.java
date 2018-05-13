package com.limitip.mm.mark_movie.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.databinding.ApiMovieListviewBinding;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends BaseAdapter {
    private DoubanMovie doubanMovie;
    private Context context;

    public MovieAdapter(DoubanMovie doubanMovie, Context context) {
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
        ViewHolder holder= ViewHolder.getViewHolder(context, R.layout.api_movie_listview, convertView, parent);
        Picasso
                .with(context)
                .load(doubanMovie.getSubjects().get(position).getImages().getSmall())
                .fit()
                .into(holder.mItemBinding.apiMovieImg);
        holder.mItemBinding.setMovie(doubanMovie.getSubjects().get(position));
        return holder.mConvertView;
    }

    public ApiMovieListviewBinding getItemBing(){
        return ViewHolder.getmItemBinding();
    }

    public DoubanMovie getDoubanMovie() {
        return doubanMovie;
    }

    public void setDoubanMovie(DoubanMovie doubanMovie) {
        this.doubanMovie = doubanMovie;
    }

    private static class ViewHolder{
        static ApiMovieListviewBinding mItemBinding;
        View mConvertView;
        private ViewHolder(Context pContext, ViewGroup parent, int pLayoutId) {
            mItemBinding = DataBindingUtil.inflate(LayoutInflater.from(pContext), pLayoutId, parent, false);
            this.mConvertView = mItemBinding.getRoot();
            this.mConvertView.setTag(this);
        }
        static ViewHolder getViewHolder(Context pContext, int pLayoutId, View convertView, ViewGroup parent) {
            if (convertView == null) {
                return new ViewHolder(pContext, parent, pLayoutId);
            }
            return (ViewHolder) convertView.getTag();
        }

        public static ApiMovieListviewBinding getmItemBinding() {
            return mItemBinding;
        }
    }
}
