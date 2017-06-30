package com.example.daniele.testgooglebooks.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniele.testgooglebooks.R;
import com.example.daniele.testgooglebooks.model.Volume;
import com.example.daniele.testgooglebooks.model.VolumeInfo;
import com.squareup.picasso.Picasso;

/**
 * Created by daniele on 30/06/17.
 */

public class BookDetailController {

    private Context mContext;
    private String mPreviewUrl;

    public BookDetailController(Context context){
        mContext = context;
    }

    public void inflateViews(View rootView, Volume volume){
        final VolumeInfo volumeInfo = volume.getVolumeInfo();

        TextView textTitle = (TextView) rootView.findViewById(R.id.text_title);
        CollapsingToolbarLayout mToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);
        TextView textAuthor = (TextView) rootView.findViewById(R.id.text_author_detail);
        TextView textNotAvailable = (TextView) rootView.findViewById(R.id.text_image_not_available);
        ImageView imageBook = (ImageView) rootView.findViewById(R.id.image_book);
        TextView textPub = (TextView) rootView.findViewById(R.id.text_publisher);
        TextView textPublisher = (TextView) rootView.findViewById(R.id.text_publisher_detail);
        TextView textDescription = (TextView) rootView.findViewById(R.id.text_description);
        TextView textPublishedDate = (TextView) rootView.findViewById(R.id.text_published_date_detail);
        TextView textLanguage = (TextView) rootView.findViewById(R.id.text_language_detail);
        TextView textPreview = (TextView) rootView.findViewById(R.id.text_preview);
        textPreview.setPaintFlags(textPreview.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mPreviewUrl = volumeInfo.getPreviewLink();
        textPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(volumeInfo.getPreviewLink()));
                mContext.startActivity(intent);
            }
        });

        textTitle.setText(volumeInfo.getTitle());
        mToolbar.setTitle("Book Details");
        String authorText = "";
        String[] authors = volumeInfo.getAuthors();
        if(authors != null){
            for(String aut : authors){
                authorText = authorText + aut + " ";
            }
        }
        authorText = authorText.trim();
        textAuthor.setText(authorText);
        String publisher = volumeInfo.getPublisher();
        if(publisher.isEmpty()){
            textPub.setVisibility(View.GONE);
        }
        else{
            textPublisher.setText(volumeInfo.getPublisher());
        }
        textDescription.setText(volumeInfo.getDescription());
        textPublishedDate.setText(volumeInfo.getPublishedDate());
        textLanguage.setText(volumeInfo.getLanguage());
        VolumeInfo.ImageLinks imageLinks = volumeInfo.getImageLinks();
        if(imageLinks != null){
            String url = "";
            if(imageLinks.getMedium() != null){
                url = imageLinks.getMedium();
            }
            else if(imageLinks.getSmall() != null){
                url = imageLinks.getSmall();
            }
            else if(imageLinks.getLarge() != null){
                url = imageLinks.getLarge();
            }
            else if(imageLinks.getThumbnail() != null){
                url = imageLinks.getThumbnail();
            }
            if(!url.isEmpty()){
                Picasso.with(mContext).load(url).into(imageBook);
            }
            else{
                textNotAvailable.setVisibility(View.VISIBLE);
            }

        }
        else{
            textNotAvailable.setVisibility(View.VISIBLE);
        }
    }
}
