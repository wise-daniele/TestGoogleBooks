package com.example.daniele.testgooglebooks.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.controller.MainController;

public class MainActivity extends AppCompatActivity implements SearchFragment.FragmentListener{

    private MainController mMainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainController = new MainController(this);
        if (findViewById(R.id.main_fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            mMainController.showSearchFragment();
        }
    }

    @Override
    public void onSearchTapped(String title, String author, String subject, String publisher, String isbn) {
        mMainController.getSearchQuery(title, author, subject, publisher, isbn);
    }
}
