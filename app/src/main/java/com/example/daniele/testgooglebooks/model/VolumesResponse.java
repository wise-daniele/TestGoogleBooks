package com.example.daniele.testgooglebooks.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by daniele on 26/06/17.
 */

public class VolumesResponse {

    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("items")
    private List<Volume> items;

    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<Volume> getItems() {
        return items;
    }
}
