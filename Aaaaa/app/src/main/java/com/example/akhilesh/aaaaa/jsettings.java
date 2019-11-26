package com.example.akhilesh.aaaaa;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class jsettings extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.layout.settings_layout); }
}
