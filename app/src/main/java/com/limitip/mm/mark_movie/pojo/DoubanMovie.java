package com.limitip.mm.mark_movie.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import java.io.Serializable;
import java.util.ArrayList;

public class DoubanMovie extends  BaseObservable implements Serializable {
    private int count;
    private int total;
    private ArrayList<DoubanSubjects> subjects;

    @Bindable
    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
        notifyPropertyChanged(BR.count);
    }

    @Bindable
    public int getTotal() {

        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        notifyPropertyChanged(BR.total);
    }

    @Bindable
    public ArrayList<DoubanSubjects> getSubjects() {

        return subjects;
    }

    public void setSubjects(ArrayList<DoubanSubjects> subjects) {
        this.subjects = subjects;
        notifyPropertyChanged(BR.subjects);
    }

    /**
     * 条目*/
    public class DoubanSubjects extends BaseObservable implements Serializable{
        private Rating rating; //评分
        private ArrayList<String> genres;//电影标签
        private String title; //名称
        private String subtype;//电影分类，E movie
        private String year;//年份
        private Images images;//图片地址
        private String alt;//豆瓣地址
        private int id;//电影id

        @Bindable
        public Rating getRating() {

            return rating;
        }

        public void setRating(Rating rating) {
            this.rating = rating;
            notifyPropertyChanged(BR.rating);
        }

        @Bindable
        public ArrayList<String> getGenres() {

            return genres;
        }

        public void setGenres(ArrayList<String> genres) {
            this.genres = genres;
            notifyPropertyChanged(BR.genres);
        }

        @Bindable
        public String getTitle() {

            return title;
        }

        public void setTitle(String title) {
            this.title = title;
            notifyPropertyChanged(BR.title);
        }

        @Bindable
        public String getSubtype() {

            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
            notifyPropertyChanged(BR.subtype);
        }

        @Bindable
        public String getYear() {

            return year;
        }

        public void setYear(String year) {
            this.year = year;
            notifyPropertyChanged(BR.year);
        }

        @Bindable
        public Images getImages() {

            return images;
        }

        public void setImages(Images images) {
            this.images = images;
            notifyPropertyChanged(BR.images);
        }

        @Bindable
        public String getAlt() {

            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
            notifyPropertyChanged(BR.alt);
        }

        @Bindable
        public int getId() {

            return id;
        }

        public void setId(int id) {
            this.id = id;
            notifyPropertyChanged(BR.id);
        }
    }

    /**
     * 评分*/
    public class Rating extends BaseObservable implements Serializable{
        private int max;
        private int min;
        private Double average;//平均
        private int stars; //评星数

        @Bindable
        public int getMax() {

            return max;
        }

        public void setMax(int max) {
            this.max = max;
            notifyPropertyChanged(BR.max);
        }

        @Bindable
        public int getMin() {

            return min;
        }

        public void setMin(int min) {
            this.min = min;
            notifyPropertyChanged(BR.min);
        }

        @Bindable
        public Double getAverage() {

            return average;
        }

        public void setAverage(Double average) {
            this.average = average;
            notifyPropertyChanged(BR.average);
        }

        @Bindable
        public int getStars() {

            return stars;
        }

        public void setStars(int stars) {
            this.stars = stars;
            notifyPropertyChanged(BR.stars);
        }
    }

    public class Images extends BaseObservable implements Serializable{
        private String small;
        private String large;
        private String medium;

        @Bindable
        public String getSmall() {

            return small;
        }

        public void setSmall(String small) {
            this.small = small;
            notifyPropertyChanged(BR.small);
        }

        @Bindable
        public String getLarge() {

            return large;
        }

        public void setLarge(String large) {
            this.large = large;
            notifyPropertyChanged(BR.large);
        }

        @Bindable
        public String getMedium() {

            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
            notifyPropertyChanged(BR.medium);
        }
    }


}
