package cz.muni.fi.pv256.movio2.uco_395986;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView method");
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate method");
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
}
