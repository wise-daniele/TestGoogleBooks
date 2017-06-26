package com.example.daniele.testgooglebooks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daniele.testgooglebooks.R;

/**
 * Created by daniele on 25/06/17.
 */

public class BooksListFragment extends Fragment {

    public static BooksListFragment newInstance() {
        BooksListFragment fragment = new BooksListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_books_list, container, false);
        return rootView;
    }
}
