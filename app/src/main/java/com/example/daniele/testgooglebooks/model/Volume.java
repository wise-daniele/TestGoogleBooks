package com.example.daniele.testgooglebooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daniele on 26/06/17.
 */

public class Volume {

    @SerializedName("kind")
    private String kind;
    @SerializedName("id")
    private String id;
    @SerializedName("etag")
    private String etag;
    @SerializedName("selfLink")
    private String selfLink;
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;
    @SerializedName("layerInfo")
    private LayerInfo layerInfo;

    @SerializedName("saleInfo")
    private VolumeInfo saleInfo;
    @SerializedName("accessInfo")
    private AccessInfo accessInfo;
    @SerializedName("searchInfo")
    private SearchInfo searchInfo;
}
