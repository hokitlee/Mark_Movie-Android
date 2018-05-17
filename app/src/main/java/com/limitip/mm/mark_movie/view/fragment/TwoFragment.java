package com.limitip.mm.mark_movie.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.clikListener.ObserverListener;
import com.limitip.mm.mark_movie.clikListener.ObserverManager;
import com.limitip.mm.mark_movie.databinding.TwoBinding;
import com.limitip.mm.mark_movie.view.MovieShowActivity;
import com.limitip.mm.mark_movie.viewmodel.MovieVM;

import java.io.Serializable;

public class TwoFragment extends Fragment implements View.OnClickListener, ObserverListener {
    private TwoBinding binding;
    private View rootView;
    private Toolbar toolbar;
    private Activity activity;
    private MovieVM movieVM = new MovieVM();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.two, container, false);
        rootView = binding.getRoot();
        initialize();
        return rootView;
    }

    private void initialize() {
        toolbar = binding.toolbar1;
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.apiMoiveGridview.setOnItemClickListener(new OICL());
        movieVM.findMySeenMovie(binding);
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void observerUpData(Object object) {
        if ((int) object == 2){
            movieVM.findMySeenMovie(binding);
        }

    }

    class OICL implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(rootView.getContext(), MovieShowActivity.class);
            intent.putExtra("movie", binding.getAdapter().getDoubanMovie().getSubjects()
                    .get(position));
            intent.putExtra("show", 2);
            rootView.getContext().startActivity(intent);

        }
    }
}
