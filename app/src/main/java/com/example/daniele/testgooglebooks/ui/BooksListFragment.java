package com.example.daniele.testgooglebooks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.model.Volume;
import com.example.daniele.testgooglebooks.ui.adapter.VolumesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by daniele on 25/06/17.
 */

public class BooksListFragment extends Fragment {

    public static final String FRAGMENT_TAG = "fragment_books_list";

    public static BooksListFragment newInstance() {
        BooksListFragment fragment = new BooksListFragment();
        return fragment;
    }

    @BindView(R.id.volumes_list_view)
    RecyclerView mVolumesView;
    private List<Volume> mVolumesList;
    private VolumesAdapter mVolumesAdapter;
    private LinearLayoutManager mLayoutManager;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_books_list, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mVolumesView.setLayoutManager(mLayoutManager);
        mVolumesAdapter = new VolumesAdapter(getActivity(), mVolumesList);
        mVolumesView.setAdapter(mVolumesAdapter);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    public void setVolumes(ArrayList<Volume> volumes){
        mVolumesList = volumes;
    }
}
