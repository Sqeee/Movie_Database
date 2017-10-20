package cz.muni.fi.pv256.movio2.uco_395986;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import cz.muni.fi.pv256.movio2.uco_395986.Models.Movie;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainFragment.class.getSimpleName();

    private SharedPreferences prefs;
    private boolean mTwoPane;
    private ArrayList<Movie> mMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate method");
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences(Settings.SHARED_PREF_LOC, Context.MODE_PRIVATE);
        setTheme(prefs.getInt(Settings.SHARED_PREF_THEME_KEY, R.style.AppTheme));
        setContentView(R.layout.activity_main);

        mMovieList = new ArrayList<>();
        long currentTime = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00")).getTime().getTime();
        mMovieList.add(new Movie(currentTime, "cover1", "Film 1", "xxx", 3.1f, R.drawable.movie));
        mMovieList.add(new Movie(currentTime, "cover2", "Film 2", "xxx", 2.1f, R.drawable.movie));
        mMovieList.add(new Movie(currentTime, "cover3", "Film 3", "xxx", 1.1f, R.drawable.movie));

        if (findViewById(R.id.movie_detail_container) != null) {
            // The detail container view will be present only in the large-screen layouts
            // (res/layout-sw600dp). If this view is present, then the activity should be
            // in two-pane mode.
            mTwoPane = true;
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.movie_detail_container, new MovieDetailFragment(), MovieDetailFragment.TAG)
                        .commit();
            }
        } else {
            mTwoPane = false;
            getSupportActionBar().setElevation(0f);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart method");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume method");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause method");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop method");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy method");
    }

    public void onButtonSwitchThemeClicked(View view) {
        if (prefs.getInt(Settings.SHARED_PREF_THEME_KEY, R.style.AppTheme) == R.style.AppTheme) {
            prefs.edit().putInt(Settings.SHARED_PREF_THEME_KEY, R.style.AppTheme2).apply();
        }
        else {
            prefs.edit().putInt(Settings.SHARED_PREF_THEME_KEY, R.style.AppTheme).apply();
        }
        recreate();
    }

    public void onButtonFilm1Clicked(View view) {
        movieSelect(0);
    }

    public void onButtonFilm2Clicked(View view) {
        movieSelect(1);
    }

    public void onButtonFilm3Clicked(View view) {
        movieSelect(2);
    }

    private void movieSelect(int index) {
        Movie movie = mMovieList.get(index);
        if (mTwoPane) {
            FragmentManager fm = getSupportFragmentManager();

            MovieDetailFragment fragment = MovieDetailFragment.newInstance(movie);
            fm.beginTransaction()
                    .replace(R.id.movie_detail_container, fragment, MovieDetailFragment.TAG)
                    .commit();

        } else {
            Intent intent = new Intent(this, MovieDetailActivity.class);
            intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
            startActivity(intent);
        }
    }
}
