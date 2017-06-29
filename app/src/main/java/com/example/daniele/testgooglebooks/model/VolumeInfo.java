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
    private IndustryIdentifiers[] industryIdentifiers;
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

        public String getSmallThumbnail() {
            return smallThumbnail;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public String getSmall() {
            return small;
        }

        public String getMedium() {
            return medium;
        }

        public String getLarge() {
            return large;
        }

        public String getExtraLarge() {
            return extraLarge;
        }
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public ReadingModes getReadingModes() {
        return readingModes;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public IndustryIdentifiers[] getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPrintedPageCount() {
        return printedPageCount;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public boolean isAllowAnonLogging() {
        return allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public String getPrintType() {
        return printType;
    }

    public String[] getCategories() {
        return categories;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }
}
