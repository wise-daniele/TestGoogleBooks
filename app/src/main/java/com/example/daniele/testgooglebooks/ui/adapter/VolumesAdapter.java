package com.example.daniele.testgooglebooks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.model.Volume;
import com.example.daniele.testgooglebooks.model.VolumeInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by daniele on 27/06/17.
 */

public class VolumesAdapter extends RecyclerView.Adapter<VolumesAdapter.VolumeViewHolder> {

    protected class VolumeViewHolder extends RecyclerView.ViewHolder {

        View myView;
        @BindView(R.id.text_book_title)
        TextView mBookTitle;
        @BindView(R.id.text_book_author)
        TextView mBookAuthor;
        @BindView(R.id.text_book_publisher)
        TextView mBookPublisher;

        public VolumeViewHolder(View view) {
            super(view);
            myView = view;
            ButterKnife.bind(this, view);
        }
    }

    private Context mContext;
    private List<Volume> mList;
    private final OnItemClickListener mListener;

    public VolumesAdapter(Context context, List<Volume> list, OnItemClickListener listener) {
        mContext = context;
        mList = list;
        mListener = listener;
    }

    @Override
    public VolumeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.view_volume_item, parent, false);
        return new VolumeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VolumeViewHolder holder, int position) {
        final Volume volume = mList.get(position);
        if(volume != null) {
            final VolumeInfo volumeInfo = volume.getVolumeInfo();
            String title = volumeInfo.getTitle();
            String[] authors = volumeInfo.getAuthors();
            String textAuthor = "";
            for(int i = 0; i < authors.length; i++){
                textAuthor = textAuthor + authors[i] + " ";
            }
            String publisher = volumeInfo.getPublisher();
            holder.mBookTitle.setText(title);
            holder.mBookAuthor.setText(textAuthor);
            holder.mBookPublisher.setText(publisher);

            holder.myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(volume.getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(mList != null){
            return mList.size();
        }
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(String itemId);
    }
}
