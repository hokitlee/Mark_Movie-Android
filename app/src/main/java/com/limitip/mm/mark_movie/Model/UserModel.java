package com.limitip.mm.mark_movie.Model;

import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.pojo.User;

public interface UserModel {
    void userLogin(User user, BaseLoadListener<User> loadListener);
    void userRegister(User user, BaseLoadListener<String> loadListener);
}
