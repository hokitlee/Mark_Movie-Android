package com.limitip.mm.mark_movie.pojo;

import java.io.Serializable;

public class Subjects implements Serializable {

    private Integer id;

    private Integer userid;

    private String token;

    private Integer movieid;

    private Integer status;

    private String title;

    private String subtype;

    private String year;

    private String images;

    private String genres;

    public Subjects() {
    }

    public Subjects(Integer id, Integer userid, String token, Integer movieid, Integer status, String title, String subtype, String year, String images, String genres) {
        this.id = id;
        this.userid = userid;
        this.token = token;
        this.movieid = movieid;
        this.status = status;
        this.title = title;
        this.subtype = subtype;
        this.year = year;
        this.images = images;
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}