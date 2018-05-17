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
import com.limitip.mm.mark_movie.databinding.ThreeBinding;
import com.limitip.mm.mark_movie.view.MovieShowActivity;
import com.limitip.mm.mark_movie.viewmodel.MovieVM;

public class ThreeFragment extends Fragment implements View.OnClickListener, ObserverListener {
    private ThreeBinding binding;
    private Activity activity;
    private View rootView;
    private Toolbar toolbar;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.three, container, false);
        rootView = binding.getRoot();
        initialize();
        return rootView;
    }

    private void initialize() {
        toolbar = binding.toolbar1;
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.apiMoiveGridview.setOnItemClickListener(new OICL());
        movieVM.findMyWantMovie(binding);
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void observerUpData(Object object) {
        if ((int) object == 1) {
            movieVM.findMyWantMovie(binding);
        }

    }

    class OICL implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(rootView.getContext(), MovieShowActivity.class);
            intent.putExtra("movie", binding.getAdapter().getDoubanMovie().getSubjects()
                    .get(position));
            intent.putExtra("show", 1);
            rootView.getContext().startActivity(intent);
        }
    }
}
