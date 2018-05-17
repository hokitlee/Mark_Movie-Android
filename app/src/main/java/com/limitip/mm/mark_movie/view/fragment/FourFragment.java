package com.limitip.mm.mark_movie.view.fragment;

import android.app.Activity;
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

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.databinding.FourBinding;
import com.wang.avi.AVLoadingIndicatorView;

public class FourFragment extends Fragment implements View.OnClickListener{
    private FourBinding binding;
    private Toolbar toolbar;
    private Activity activity;
    private View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.four, container, false);
        rootView = binding.getRoot();
        initialize();
        return rootView;
    }

    private void initialize(){
        toolbar = binding.toolbar1;
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.cator1.smoothToShow();
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cator1:{
                binding.cator1.hide();
            }
        }
    }
}
