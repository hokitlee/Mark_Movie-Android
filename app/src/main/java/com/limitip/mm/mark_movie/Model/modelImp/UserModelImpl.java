package com.limitip.mm.mark_movie.Model.modelImp;

import com.limitip.mm.mark_movie.Model.UserModel;
import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.base.BaseObserver;
import com.limitip.mm.mark_movie.pojo.Message;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.service.user.UserService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserModelImpl implements UserModel {
    private User resultUser;
    @Override
    public void userLogin(final User user, final BaseLoadListener<User> loadListener) {

        UserService.userService.DouserLogin(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<User>() {
                    @Override
                    public void onNext(User user) {
                        loadListener.LoadSuccess(user);
                    }

                    @Override
                    public void onError(Throwable throwabale) {
                        loadListener.LoadFail("异常错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void userRegister(final User user, final BaseLoadListener<String> loadListener) {
        UserService.userService.DoRegister(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Message>(){

                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Message message) {
                        loadListener.LoadSuccess(message.getMsg());
                    }

                    @Override
                    public void onError(Throwable throwabale) {
                        System.out.println(throwabale.toString());
                        loadListener.LoadFail("异常错误");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
}
