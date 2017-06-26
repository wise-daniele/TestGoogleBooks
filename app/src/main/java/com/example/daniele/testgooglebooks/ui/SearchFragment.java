package com.example.daniele.testgooglebooks.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniele.testgooglebooks.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by daniele on 25/06/17.
 */

public class SearchFragment extends Fragment {

    public static final String FRAGMENT_TAG = "fragment_search";

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    private FragmentListener mListener;
    @BindView(R.id.edit_text_title)
    TextView mTextTitle;
    @BindView(R.id.edit_text_author)
    TextView mTextAuthor;
    @BindView(R.id.edit_text_publisher)
    TextView mTextPublisher;
    @BindView(R.id.edit_text_subject)
    TextView mTextSubject;
    @BindView(R.id.edit_text_isbn)
    TextView mTextIsbn;
    @BindView(R.id.button_search)
    TextView mButtonSearch;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: check id data is ok and get query
                mListener.onSearchTapped("");
            }
        });
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (FragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface FragmentListener{

        void onSearchTapped(String query);
    }
}
