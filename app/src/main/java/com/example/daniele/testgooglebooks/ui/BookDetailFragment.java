package com.example.daniele.testgooglebooks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.model.Volume;

/**
 * Created by daniele on 25/06/17.
 */

public class BookDetailFragment extends Fragment {

    public static final String FRAGMENT_TAG = "fragment_book_detail";

    public static BookDetailFragment newInstance() {
        BookDetailFragment fragment = new BookDetailFragment();
        return fragment;
    }

    private Volume mVolume;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_detail, container, false);
        return rootView;
    }

    public void setVolume(Volume volume){
        mVolume = volume;
    }
}
