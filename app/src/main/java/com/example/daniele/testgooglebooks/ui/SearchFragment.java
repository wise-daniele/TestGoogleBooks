package com.example.daniele.testgooglebooks.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.controller.MainController;

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
    @BindView(R.id.text_input_layout_title)
    TextInputLayout mTextInputLayoutTitle;
    @BindView(R.id.edit_text_title)
    TextInputEditText mTextTitle;
    @BindView(R.id.edit_text_author)
    TextInputEditText mTextAuthor;
    @BindView(R.id.edit_text_subject)
    TextInputEditText mTextSubject;
    @BindView(R.id.edit_text_publisher)
    TextInputEditText mTextPublisher;
    @BindView(R.id.edit_text_isbn)
    TextInputEditText mTextIsbn;
    @BindView(R.id.button_search)
    Button mButtonSearch;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        mTextTitle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mTextInputLayoutTitle.setError(null);
                return false;
            }
        });

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inputValidation = mListener.onSearchTapped(
                        mTextTitle.getText().toString(),
                        mTextAuthor.getText().toString(),
                        mTextSubject.getText().toString(),
                        mTextPublisher.getText().toString(),
                        mTextIsbn.getText().toString()
                );
                if(!inputValidation){
                    mTextInputLayoutTitle.setError(getString(R.string.text_input_error));
                }
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

        boolean onSearchTapped(
                String title,
                String author,
                String subject,
                String publisher,
                String isbn
        );
    }
}
