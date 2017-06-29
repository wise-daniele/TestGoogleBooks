package com.example.daniele.testgooglebooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daniele on 26/06/17.
 */

public class SaleInfo {

    @SerializedName("country")
    private String country;
    @SerializedName("saleability")
    private String saleability;
    @SerializedName("isEbook")
    private boolean isEbook;
    @SerializedName("buyLink")
    private String buyLink;

    public String getCountry() {
        return country;
    }

    public String getSaleability() {
        return saleability;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public String getBuyLink() {
        return buyLink;
    }
}
