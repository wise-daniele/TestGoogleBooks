package com.example.daniele.testgooglebooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daniele on 26/06/17.
 */

public class VolumeInfo {

    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private String[] authors;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("description")
    private String description;
    @SerializedName("readingModes")
    private ReadingModes readingModes;
    @SerializedName("dimensions")
    private Dimensions dimensions;
    @SerializedName("averageRating")
    private double averageRating;
    @SerializedName("ratingsCount")
    private int ratingsCount;
    @SerializedName("industryIdentifiers")
    private IndustryIdentifiers industryIdentifiers;
    @SerializedName("pageCount")
    private int pageCount;
    @SerializedName("printedPageCount")
    private int printedPageCount;
    @SerializedName("maturityRating")
    private String maturityRating;
    @SerializedName("allowAnonLogging")
    private boolean allowAnonLogging;
    @SerializedName("contentVersion")
    private String contentVersion;

    @SerializedName("printType")
    private String printType;
    @SerializedName("categories")
    private String[] categories;
    @SerializedName("imageLinks")
    private ImageLinks imageLinks;
    @SerializedName("language")
    private String language;
    @SerializedName("previewLink")
    private String previewLink;
    @SerializedName("infoLink")
    private String infoLink;
    @SerializedName("canonicalVolumeLink")
    private String canonicalVolumeLink;

    public class ReadingModes {

        @SerializedName("text")
        private boolean text;
        @SerializedName("image")
        private boolean image;
    }

    public class Dimensions {

        @SerializedName("height")
        private String height;

    }

    public class IndustryIdentifiers {

        @SerializedName("type")
        private String type;
        @SerializedName("identifier")
        private String identifier;
    }

    public class ImageLinks {

        @SerializedName("smallThumbnail")
        private String smallThumbnail;
        @SerializedName("thumbnail")
        private String thumbnail;
        @SerializedName("small")
        private String small;
        @SerializedName("medium")
        private String medium;
        @SerializedName("large")
        private String large;
        @SerializedName("extraLarge")
        private String extraLarge;
    }
}
