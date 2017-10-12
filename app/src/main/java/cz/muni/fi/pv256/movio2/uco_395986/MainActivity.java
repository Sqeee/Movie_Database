package cz.muni.fi.pv256.movio2.uco_395986;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences(Settings.SHARED_PREF_LOC, Context.MODE_PRIVATE);
        setTheme(prefs.getInt(Settings.SHARED_PREF_THEME_KEY, R.style.AppTheme));
        setContentView(R.layout.activity_main);
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
}
