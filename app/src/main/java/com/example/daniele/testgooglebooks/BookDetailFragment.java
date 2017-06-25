package com.example.daniele.testgooglebooks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by daniele on 25/06/17.
 */

public class BookDetailFragment extends Fragment {

    public static BookDetailFragment newInstance() {
        BookDetailFragment fragment = new BookDetailFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_detail, container, false);
        return rootView;
    }
}
