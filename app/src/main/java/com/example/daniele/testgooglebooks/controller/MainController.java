package com.example.daniele.testgooglebooks.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.model.Volume;
import com.example.daniele.testgooglebooks.model.VolumesResponse;
import com.example.daniele.testgooglebooks.rest.RestClient;
import com.example.daniele.testgooglebooks.ui.BookDetailFragment;
import com.example.daniele.testgooglebooks.ui.BooksListFragment;
import com.example.daniele.testgooglebooks.ui.MainActivity;
import com.example.daniele.testgooglebooks.ui.SearchFragment;
import com.example.daniele.testgooglebooks.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by daniele on 26/06/17.
 */

public class MainController {

    public static final String LOG_TAG = MainController.class.getSimpleName();

    private MainActivity mActivity;
    private SearchFragment mSearchFragment;
    private BooksListFragment mBooksListFragment;
    private BookDetailFragment mBookDetailFragment;

    public MainController(MainActivity activity){
        mActivity = activity;
        mSearchFragment = SearchFragment.newInstance();
    }

    /**
     * Replace the main fragment with the search fragment
     */
    public void showSearchFragment(){
        if(mSearchFragment == null){
            mSearchFragment = SearchFragment.newInstance();
        }
        replaceFragment(R.id.main_fragment_container, mSearchFragment, SearchFragment.FRAGMENT_TAG, true);
    }

    /**
     * Replace the main fragment with the books list fragment
     */
    public void showBooksListFragment(ArrayList<Volume> volumes){
        if(mBooksListFragment == null){
            mBooksListFragment = BooksListFragment.newInstance();
        }
        mBooksListFragment.setVolumes(volumes);
        replaceFragment(R.id.main_fragment_container, mBooksListFragment, BooksListFragment.FRAGMENT_TAG, true);
    }

    /**
     * Replace the main fragment with the book detail fragment
     */
    public void showBookDetailFragment(Volume volume){
        if(mBookDetailFragment == null){
            mBookDetailFragment = BookDetailFragment.newInstance();
        }
        mBookDetailFragment.setVolume(volume);
        replaceFragment(R.id.main_fragment_container, mBooksListFragment, BookDetailFragment.FRAGMENT_TAG, true);
    }

    /**
     * Replaces the fragment within a container
     * @param containerId Id of the container of the fragment that will be replaced
     * @param fragment Fragment to add in the container
     * @param tag tag relative to the fragment
     * @param addToBackStack true if the we want to maintain the current fragment in the stack
     * @return
     */
    private int replaceFragment(int containerId, Fragment fragment, String tag, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = mActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment, tag);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        return fragmentTransaction.commit();
    }

    public void onSearchTapped(String title, String author, String publisher, String subject, String isbn){
        String searchQuery = getSearchQuery(title, author, publisher, subject, isbn);
        RestClient.GoogleBooksInterface service = RestClient.getInstance().getClient().create(RestClient.GoogleBooksInterface.class);
        Call<VolumesResponse> call = service.getVolumes(searchQuery.toString());
        call.enqueue(new Callback<VolumesResponse>() {
            @Override
            public void onResponse(Call<VolumesResponse> call, Response<VolumesResponse> response) {
                ArrayList<Volume> volumes = (ArrayList<Volume>) response.body().getItems();
                showBooksListFragment(volumes);
            }

            @Override
            public void onFailure(Call<VolumesResponse> call, Throwable t) {
                Log.d(LOG_TAG, "Call onFailure " + t.getMessage());
            }

        });
    }

    public void onListItemTapped(String itemId){
        RestClient.GoogleBooksInterface service = RestClient.getInstance().getClient().create(RestClient.GoogleBooksInterface.class);
        Call<Volume> call = service.getVolumeById(itemId);
        call.enqueue(new Callback<Volume>() {
            @Override
            public void onResponse(Call<Volume> call, Response<Volume> response) {
                //TODO: open detail fragment
                showBookDetailFragment(response.body());
            }

            @Override
            public void onFailure(Call<Volume> call, Throwable t) {
                Log.d(LOG_TAG, "Call onFailure " + t.getMessage());
            }

        });
    }

    private String getSearchQuery(String title, String author, String publisher, String subject, String isbn){
        StringBuilder searchQuery = new StringBuilder();
        boolean firstAdded = false;
        if(!TextUtils.isEmpty(title)){
            String query = (Constants.QUERY_TITLE + title).trim();
            if(firstAdded){
                query = "+" + query;
            }
            searchQuery.append(query);
            firstAdded = true;
        }
        if(!TextUtils.isEmpty(author)){
            String query = (Constants.QUERY_AUTHOR + author).trim();
            if(firstAdded){
                query = "+" + query;
            }
            searchQuery.append(query);
            firstAdded = true;
        }
        if(!TextUtils.isEmpty(subject)){
            String query = (Constants.QUERY_SUBJECT + subject).trim();
            if(firstAdded){
                query = "+" + query;
            }
            searchQuery.append(query);
            firstAdded = true;
        }
        if(!TextUtils.isEmpty(publisher)){
            String query = (Constants.QUERY_PUBLISHER + publisher).trim();
            if(firstAdded){
                query = "+" + query;
            }
            searchQuery.append(query);
            firstAdded = true;
        }
        if(!TextUtils.isEmpty(isbn)){
            String query = (Constants.QUERY_ISBN + isbn).trim();
            if(firstAdded){
                query = "+" + query;
            }
            searchQuery.append(query);
            firstAdded = true;
        }
        return searchQuery.toString();
    }

}
