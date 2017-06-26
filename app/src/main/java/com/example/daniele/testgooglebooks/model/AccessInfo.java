package com.example.daniele.testgooglebooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daniele on 26/06/17.
 */

public class AccessInfo {

    @SerializedName("country")
    private String country;
    @SerializedName("viewability")
    private String viewability;
    @SerializedName("embeddable")
    private boolean embeddable;
    @SerializedName("publicDomain")
    private boolean publicDomain;
    @SerializedName("textToSpeechPermission")
    private String textToSpeechPermission;
    @SerializedName("epub")
    private Epub epub;
    @SerializedName("pdf")
    private Pdf pdf;
    @SerializedName("webReaderLink")
    private String webReaderLink;
    @SerializedName("accessViewStatus")
    private String accessViewStatus;
    @SerializedName("quoteSharingAllowed")
    private boolean quoteSharingAllowed;

    public class Epub {

        @SerializedName("isAvailable")
        private boolean isAvailable;
        @SerializedName("downloadLink")
        private String downloadLink;

    }

    public class Pdf {

        @SerializedName("isAvailable")
        private boolean isAvailable;
        @SerializedName("downloadLink")
        private String downloadLink;

    }
}
