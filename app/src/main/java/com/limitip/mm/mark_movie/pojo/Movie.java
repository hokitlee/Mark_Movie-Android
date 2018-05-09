package com.limitip.mm.mark_movie.pojo;

/**
 * User: hokitlee
 * Date: 2018/4/11
 * Time: 19:34
 * Description:
 */
public class Movie {
    private int id;
    private String movieName;
    private String movieType;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}