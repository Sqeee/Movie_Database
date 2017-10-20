package cz.muni.fi.pv256.movio2.uco_395986;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cz.muni.fi.pv256.movio2.uco_395986.Models.Movie;

public class MovieDetailFragment extends Fragment {

    public static final String TAG = MovieDetailFragment.class.getSimpleName();
    private static final String ARGS_MOVIE = "args_movie";

    private Context mContext;
    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARGS_MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate method");

        super.onCreate(savedInstanceState);
        mContext = getActivity();
        Bundle args = getArguments();
        if (args != null) {
            mMovie = args.getParcelable(ARGS_MOVIE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView method");
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        TextView titleTv = (TextView) view.findViewById(R.id.detail_movie);
        TextView yearTv = (TextView) view.findViewById(R.id.detail_movie_year);
        ImageView iconIv = (ImageView) view.findViewById(R.id.detail_icon);
        ImageView coverIv = (ImageView) view.findViewById(R.id.detail_cover);

        if (mMovie != null) {
            titleTv.setText(mMovie.getTitle());
            yearTv.setText(new DateTime(mMovie.getReleaseDate()).year().getAsText());
            setImage(coverIv, mMovie);
            setImage(iconIv, mMovie);
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach method");
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

    private void setImage(ImageView coverIv, Movie movie) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            coverIv.setImageDrawable(mContext.getDrawable(movie.getCoverId()));
        } else {
            coverIv.setImageDrawable(mContext.getResources().getDrawable(movie.getCoverId()));
        }
    }
}
