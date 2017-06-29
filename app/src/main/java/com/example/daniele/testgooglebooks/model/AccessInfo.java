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
    private EpubOrPdf epub;
    @SerializedName("pdf")
    private EpubOrPdf pdf;
    @SerializedName("webReaderLink")
    private String webReaderLink;
    @SerializedName("accessViewStatus")
    private String accessViewStatus;
    @SerializedName("quoteSharingAllowed")
    private boolean quoteSharingAllowed;

    public String getCountry() {
        return country;
    }

    public String getViewability() {
        return viewability;
    }

    public boolean isEmbeddable() {
        return embeddable;
    }

    public boolean isPublicDomain() {
        return publicDomain;
    }

    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    public EpubOrPdf getEpub() {
        return epub;
    }

    public EpubOrPdf getPdf() {
        return pdf;
    }

    public String getWebReaderLink() {
        return webReaderLink;
    }

    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    public boolean isQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    public class EpubOrPdf {

        @SerializedName("isAvailable")
        private boolean isAvailable;
        @SerializedName("downloadLink")
        private String downloadLink;

        public boolean isAvailable() {
            return isAvailable;
        }

        public String getDownloadLink() {
            return downloadLink;
        }
    }
}
