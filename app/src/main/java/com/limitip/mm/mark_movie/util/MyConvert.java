package com.limitip.mm.mark_movie.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.pojo.Subjects;

import java.util.ArrayList;
import java.util.Arrays;


public class MyConvert {

    public static Subjects convertoSubjects(DoubanMovie.DoubanSubjects doubanSubjects) {
        Subjects subjects = new Subjects();
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                //过滤掉字段名包含"id","address"的字段
                return f.getName().contains("genres") | f.getName().contains("images");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                //过滤掉 类名包含 Bean的类
                return clazz.getName().contains("Bean");
            }
        }).create();
        String json = gson.toJson(doubanSubjects);
        subjects = gson.fromJson(json, Subjects.class);
        subjects.setImages(doubanSubjects.getImages().getSmall() + ","
                + doubanSubjects.getImages().getMedium() + ","
                + doubanSubjects.getImages().getLarge());
        String gen = doubanSubjects.getGenres().toString();
        subjects.setGenres(gen.substring(1, gen.length() - 1));
        return subjects;
    }

    public static DoubanMovie.DoubanSubjects convertoDBSubjects(Subjects subjects) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                //过滤掉字段名包含"id","address"的字段
                return f.getName().contains("genres") | f.getName().contains("images");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                //过滤掉 类名包含 Bean的类
                return clazz.getName().contains("Bean");
            }
        }).create();
        String json = gson.toJson(subjects);
        DoubanMovie.DoubanSubjects doubanSubjects = gson.fromJson(json, DoubanMovie.DoubanSubjects.class);
        ArrayList gen = new ArrayList(Arrays.asList(subjects.getGenres().split(",")));
        doubanSubjects.setGenres(gen);
        ArrayList<String> img = new ArrayList(Arrays.asList(subjects.getImages().split(",")));
        DoubanMovie.Images images = new DoubanMovie().new Images();
        try {
            images.setSmall(img.get(0));
            images.setMedium(img.get(1));
            images.setLarge(img.get(2));
        } catch (Exception e) {
        }
        doubanSubjects.setImages(images);
        return doubanSubjects;
    }
}
