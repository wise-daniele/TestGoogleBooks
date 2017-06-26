package com.example.daniele.testgooglebooks.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daniele.testgooglebooks.R;

public class MainActivity extends AppCompatActivity {

    private Fragment mSearchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.main_fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            mSearchFragment = SearchFragment.newInstance();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_fragment_container, mSearchFragment, SearchFragment.FRAGMENT_TAG);
            fragmentTransaction.commit();
        }
    }
}
