package com.example.daniele.testgooglebooks.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.ui.MainActivity;
import com.example.daniele.testgooglebooks.ui.SearchFragment;

/**
 * Created by daniele on 26/06/17.
 */

public class MainController {

    private MainActivity mActivity;
    private Fragment mSearchFragment;

    public MainController(MainActivity activity){
        mActivity = activity;
        mSearchFragment = SearchFragment.newInstance();
    }

    /**
     * Replace the main fragment with the search fragment
     */
    public void showSearchFragment(){
        mSearchFragment = SearchFragment.newInstance();
        replaceFragment(R.id.main_fragment_container, mSearchFragment, SearchFragment.FRAGMENT_TAG, true);
    }

    /**
     * Replaces the fragment within a container
     * @param containerId Id of the container of the fragment that will be replaced
     * @param fragment Fragment to add in the container
     * @param tag tag relative to the fragment
     * @param addToBackStack true if the we want to maintain the current fragment in the stack
     * @return
     */
    private int replaceFragment(int containerId, Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = mActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment, tag);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        return fragmentTransaction.commit();
    }

    public void onSearchTapped(String query){
        //TODO: call rest service
    }

}
