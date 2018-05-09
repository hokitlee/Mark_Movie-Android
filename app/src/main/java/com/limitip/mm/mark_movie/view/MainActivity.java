package com.limitip.mm.mark_movie.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.fragment.FiveFragment;
import com.limitip.mm.mark_movie.fragment.FourFragment;
import com.limitip.mm.mark_movie.fragment.OneFragment;
import com.limitip.mm.mark_movie.fragment.ThreeFragment;
import com.limitip.mm.mark_movie.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private FragmentManager fragmentManager;
    private Fragment oneFragment, twoFragment, threeFragment, fourFragment, fiveFragment;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        RadioGroup tabGradio = findViewById(R.id.tab_radio);
        tabGradio.setOnCheckedChangeListener(this);
        if(oneFragment == null){
            oneFragment = new OneFragment();
        }
        fragmentManager.beginTransaction().add(R.id.fragment_container,oneFragment,"oneFragment").commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        oneFragment = fragmentManager.findFragmentByTag("oneFragment");
        twoFragment = fragmentManager.findFragmentByTag("twoFragment");
        threeFragment = fragmentManager.findFragmentByTag("threeFragment");
        fourFragment = fragmentManager.findFragmentByTag("fourFragment");
        fiveFragment = fragmentManager.findFragmentByTag("fiveFragment");
        if (oneFragment != null) {
            transaction.hide(oneFragment);
        }
        if (twoFragment != null) {
            transaction.hide(twoFragment);
        }
        if (threeFragment != null) {
            transaction.hide(threeFragment);
        }
        if (fourFragment != null) {
            transaction.hide(fourFragment);
        }
        if (fiveFragment != null) {
            transaction.hide(fiveFragment);
        }

        switch (checkedId){
            case R.id.one:
                if(oneFragment == null){
                    oneFragment = new OneFragment();
                    transaction.add(R.id.fragment_container,oneFragment,"oneFragment");
                } else{
                    transaction.show(oneFragment);
                }
                break;
            case R.id.two:
                if(twoFragment == null){
                    twoFragment = new TwoFragment();
                    transaction.add(R.id.fragment_container,twoFragment,"twoFragment");
                }else{
                    transaction.show(twoFragment);
                }
                transaction.show(twoFragment);
                break;
            case R.id.three:
                if(threeFragment == null){
                    threeFragment = new ThreeFragment();
                    transaction.add(R.id.fragment_container,threeFragment,"threeFragment");
                }
                transaction.show(threeFragment);
                break;
            case R.id.four:
                if(fourFragment == null){
                    fourFragment = new FourFragment();
                    transaction.add(R.id.fragment_container,fourFragment,"fourFragment");
                }
                transaction.show(fourFragment);
                break;
            case R.id.five:
                if(fiveFragment == null){
                    fiveFragment = new FiveFragment();
                    transaction.add(R.id.fragment_container, fiveFragment, "fiveFragment");
                }
                transaction.show(fiveFragment);
                break;
             default:
                 break;
        }
        transaction.commit();
    }
}
