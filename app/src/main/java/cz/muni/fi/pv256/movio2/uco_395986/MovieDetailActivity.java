package cz.muni.fi.pv256.movio2.uco_395986;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cz.muni.fi.pv256.movio2.uco_395986.Models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private static final String TAG = MainFragment.class.getSimpleName();

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate method");
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences(Settings.SHARED_PREF_LOC, Context.MODE_PRIVATE);
        setTheme(prefs.getInt(Settings.SHARED_PREF_THEME_KEY, R.style.AppTheme));
        setContentView(R.layout.activity_movie_detail);

        if(savedInstanceState == null){
            Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
            FragmentManager fm = getSupportFragmentManager();
            MovieDetailFragment fragment = (MovieDetailFragment) fm.findFragmentById(R.id.movie_detail_container);

            if (fragment == null) {
                fragment = MovieDetailFragment.newInstance(movie);
                fm.beginTransaction()
                        .add(R.id.movie_detail_container, fragment)
                        .commit();
            }
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
}