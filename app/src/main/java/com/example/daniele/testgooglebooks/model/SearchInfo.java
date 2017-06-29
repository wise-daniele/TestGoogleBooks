package com.example.daniele.testgooglebooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daniele on 26/06/17.
 */

public class SearchInfo {

    @SerializedName("textSnippet")
    private String textSnippet;

    public String getTextSnippet() {
        return textSnippet;
    }
}
