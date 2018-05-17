package com.limitip.mm.mark_movie.viewmodel;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.limitip.mm.mark_movie.Model.MovieModel;
import com.limitip.mm.mark_movie.Model.modelImp.MovieModelImpl;
import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.adapter.CustomDialog;
import com.limitip.mm.mark_movie.adapter.MovieAdapter;
import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.clikListener.ObserverListener;
import com.limitip.mm.mark_movie.clikListener.ObserverManager;
import com.limitip.mm.mark_movie.databinding.ActivityMovieShowBinding;
import com.limitip.mm.mark_movie.databinding.ActivitySearchMovieBinding;
import com.limitip.mm.mark_movie.databinding.ThreeBinding;
import com.limitip.mm.mark_movie.databinding.TwoBinding;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.databinding.OneBinding;
import com.limitip.mm.mark_movie.pojo.Message;
import com.limitip.mm.mark_movie.pojo.Subjects;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.util.GetActivity;
import com.limitip.mm.mark_movie.util.Id;
import com.limitip.mm.mark_movie.util.MyConvert;
import com.limitip.mm.mark_movie.view.fragment.ThreeFragment;
import com.limitip.mm.mark_movie.view.fragment.TwoFragment;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;

public class MovieVM {

    public void nowShowMovieVM(final OneBinding binding) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()), R.style.CustomDialog);
        dialog.show();
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getNowShowMovie(new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(resultDoubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(resultDoubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
                dialog.dismiss();
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

    public void comingSoonMovie(final OneBinding binding) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()), R.style.CustomDialog);
        dialog.show();
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getComingSoonMovie(new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(resultDoubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(resultDoubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
                dialog.dismiss();
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

    public void top250Movie(final OneBinding binding) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()), R.style.CustomDialog);
        dialog.show();
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getTop250Movie(new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(resultDoubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(resultDoubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
                dialog.dismiss();
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

    public void searchMovie(String search, final ActivitySearchMovieBinding binding) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()), R.style.CustomDialog);
        dialog.show();
        MovieModel movieModel = new MovieModelImpl();
        movieModel.getSearchMovie(search, new BaseLoadListener<DoubanMovie>() {
            @Override
            public void LoadSuccess(DoubanMovie resultDoubanMovie) {
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(resultDoubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(resultDoubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
                dialog.dismiss();
            }

            @Override
            public void LoadFail(String msg) {

            }
        });
    }

    public void addMyMovie(DoubanMovie.DoubanSubjects doubanSubjects,
                           final int status, final ActivityMovieShowBinding binding) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()),
                R.style.CustomDialog);
        dialog.show();
        MovieModel movieModel = new MovieModelImpl();
        Subjects subjects = MyConvert.convertoSubjects(doubanSubjects);
        subjects.setUserid(Id.id);
        subjects.setToken(Id.token);
        subjects.setStatus(status);
        subjects.setMovieid(subjects.getId());
        subjects.setId(0);
        movieModel.addMyMovie(subjects, status, new BaseLoadListener<String>() {
            @Override
            public void LoadSuccess(String msg) {
                dialog.dismiss();
                if (msg.equals("Fail")) {
                    Toast.makeText(GetActivity.getActivityFromView(binding.getRoot()), "已存在", Toast.LENGTH_SHORT).show();
                } else {
                    ObserverManager.getInstance().notifyObserver(status);
                    Toast.makeText(GetActivity.getActivityFromView(binding.getRoot()), "已加入", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

    public void findMySeenMovie(final TwoBinding binding) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()), R.style.CustomDialog);
        dialog.show();

        MovieModel movieModel = new MovieModelImpl();
        User user = new User();
        user.setId(Id.id);
        user.setStatus(2);
        final Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization().create();
        final Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("status", 2);
        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), gson2.toJson(map));
        movieModel.findMyMovie(requestBody, new BaseLoadListener<Map<String, ArrayList>>() {
            @Override
            public void LoadSuccess(Map<String, ArrayList> map1) {
                DoubanMovie doubanMovie = new DoubanMovie();
                doubanMovie.setSubjects(new ArrayList<DoubanMovie.DoubanSubjects>());
                ArrayList<Subjects> subjectsArrayList = map1.get("subjects");
                for (Subjects a : subjectsArrayList) {
                    doubanMovie.getSubjects().add(MyConvert.convertoDBSubjects(a));
                }
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(doubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(doubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
                dialog.dismiss();
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

    public void findMyWantMovie(final ThreeBinding binding) {

        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()), R.style.CustomDialog);
        dialog.show();
        MovieModel movieModel = new MovieModelImpl();
        User user = new User();
        user.setId(Id.id);
        user.setStatus(1);
        final Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization().create();
        final Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("status", 1);
        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), gson2.toJson(map));
        movieModel.findMyMovie(requestBody, new BaseLoadListener<Map<String, ArrayList>>() {
            @Override
            public void LoadSuccess(Map<String, ArrayList> map1) {
                DoubanMovie doubanMovie = new DoubanMovie();
                doubanMovie.setSubjects(new ArrayList<DoubanMovie.DoubanSubjects>());
                ArrayList<Subjects> subjectsArrayList = map1.get("subjects");
                for (Subjects a : subjectsArrayList) {
                    doubanMovie.getSubjects().add(MyConvert.convertoDBSubjects(a));
                }
                if (binding.getAdapter() == null) {
                    MovieAdapter movieAdapter = new MovieAdapter(doubanMovie, binding.getRoot().getContext());
                    binding.setAdapter(movieAdapter);
                } else {
                    binding.getAdapter().setDoubanMovie(doubanMovie);
                    binding.setAdapter(binding.getAdapter());
                }
                dialog.dismiss();
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

    public void deleteMyWantMovie(final int status , DoubanMovie.DoubanSubjects doubanSubjects,
                                  final ActivityMovieShowBinding  binding){

        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(binding.getRoot()), R.style.CustomDialog);
        dialog.show();

        final MovieModel movieModel = new MovieModelImpl();
        User user = new User();
        user.setId(Id.id);
        user.setStatus(1);
        final Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization().create();
        final Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("status",status);
        Subjects subjects = MyConvert.convertoSubjects(doubanSubjects);
        map.put("doubanMovie",subjects);
        RequestBody requestBody = RequestBody
                .create(okhttp3.MediaType.parse("application/json; charset=utf-8"), gson2.toJson(map));
        movieModel.deleteMyMovie(requestBody, new BaseLoadListener<Message>() {
            @Override
            public void LoadSuccess(Message message) {
                if (message.getMsg().equals("Success")){
                    Toast.makeText(GetActivity.getActivityFromView(binding.getRoot()),message.getMsg(),
                            Toast.LENGTH_SHORT).show();
                    ObserverManager.getInstance().notifyObserver(status);
                    dialog.dismiss();
                }else {
                    Toast.makeText(GetActivity.getActivityFromView(binding.getRoot()),message.getMsg(),
                            Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

}
