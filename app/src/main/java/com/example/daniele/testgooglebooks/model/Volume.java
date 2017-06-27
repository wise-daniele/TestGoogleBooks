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

    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public LayerInfo getLayerInfo() {
        return layerInfo;
    }

    public VolumeInfo getSaleInfo() {
        return saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public SearchInfo getSearchInfo() {
        return searchInfo;
    }
}
