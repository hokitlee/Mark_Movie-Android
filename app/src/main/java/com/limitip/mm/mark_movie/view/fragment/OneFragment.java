package com.limitip.mm.mark_movie.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.clikListener.ObserverListener;
import com.limitip.mm.mark_movie.clikListener.ObserverManager;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.service.movie.movieImpl.GetComingSoonMovieServicempl;
import com.limitip.mm.mark_movie.service.movie.movieImpl.GetNowShowMovieServiceImpl;
import com.limitip.mm.mark_movie.service.movie.movieImpl.GetTop250MovieServiceImpl;
import com.limitip.mm.mark_movie.service.movie.MovieService;
import com.limitip.mm.mark_movie.view.SearchMovieActivity;

public class OneFragment extends Fragment implements View.OnClickListener,ObserverListener{

    private View rootView;
    private Activity activity;
    private MovieService movieService;
    private Toolbar toolbar;
    private LayoutInflater inflater;
    private SearchView searchView;
    private Button nowShow;
    private Button comingSoon;
    private Button top250;
    private GridView gridView;
    private DoubanMovie doubanMovie;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        rootView = inflater.inflate(R.layout.one, container, false);
        initialize();
        movieService = new GetComingSoonMovieServicempl(this);
        movieService.getMovice();
        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
        menu.add(Menu.NONE, 1 + 1, 0, "设置");
        searchView = (SearchView) menu.findItem(R.id.toolbar_search).getActionView();
        searchView.setQueryHint("搜索电影");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.setIconified(true);
                Intent intent = new Intent(activity, SearchMovieActivity.class);
                intent.putExtra("searchContext", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nowShow:
                movieService = new GetNowShowMovieServiceImpl(this);
                movieService.getMovice();
                break;
            case R.id.comingSoon:
                movieService = new GetComingSoonMovieServicempl(this);
                movieService.getMovice();
                break;
            case R.id.top250:
                movieService = new GetTop250MovieServiceImpl(this);
                movieService.getMovice();
                break;
            default:
                Toast.makeText(activity, "default", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initialize() {
        nowShow =  rootView.findViewById(R.id.nowShow);
        comingSoon =  rootView.findViewById(R.id.comingSoon);
        top250 =  rootView.findViewById(R.id.top250);
        toolbar = rootView.findViewById(R.id.toolbar1);
        gridView = rootView.findViewById(R.id.apiMoiveGridview);
        nowShow.setOnClickListener(this);
        comingSoon.setOnClickListener(this);
        top250.setOnClickListener(this);
        gridView.setOnItemClickListener(new OICL());
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void observerUpData(Object object) {
        doubanMovie = (DoubanMovie) object;
    }

    class OICL implements AdapterView.OnItemClickListener{
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           String apiMovieNmae = ((TextView)view.findViewById(R.id.apiMovieNmae)).getText().toString();
           Toast.makeText(activity, apiMovieNmae, Toast.LENGTH_SHORT).show();
       }
   }
}
