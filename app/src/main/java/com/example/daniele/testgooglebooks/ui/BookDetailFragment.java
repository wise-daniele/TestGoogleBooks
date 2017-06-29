package com.example.daniele.testgooglebooks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.model.Volume;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by daniele on 25/06/17.
 */

public class BookDetailFragment extends Fragment {

    public static final String FRAGMENT_TAG = "fragment_book_detail";
    public static final String LOG_TAG = BookDetailFragment.class.getSimpleName();

    public static BookDetailFragment newInstance() {
        BookDetailFragment fragment = new BookDetailFragment();
        return fragment;
    }

    /*
    @BindView(R.id.text_title)
    TextView mBookTitle;
    @BindView(R.id.text_author)
    TextView mBookAuthor;
    */
    private Volume mVolume;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_detail, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        //mBookTitle.setText(mVolume.getVolumeInfo().getTitle());

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    public void setVolume(Volume volume){
        mVolume = volume;
    }
}
