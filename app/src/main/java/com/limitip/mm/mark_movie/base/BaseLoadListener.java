package com.limitip.mm.mark_movie.base;

import java.util.List;

public interface BaseLoadListener<T> {
    void LoadSuccess(T t);

    void LoadFail(String msg);

}
