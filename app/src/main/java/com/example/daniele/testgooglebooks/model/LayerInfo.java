package com.example.daniele.testgooglebooks.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by daniele on 26/06/17.
 */

public class LayerInfo {

    @SerializedName("layers")
    private List<Layer> layers;


    public class Layer {

        @SerializedName("layerId")
        private String layerId;
        @SerializedName("volumeAnnotationVersion")
        private String volumeAnnotationVersion;

    }
}
