package com.example.daniele.testgooglebooks.rest;

import com.example.daniele.testgooglebooks.model.Volume;
import com.example.daniele.testgooglebooks.model.VolumesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by daniele on 26/06/17.
 */

public class RestClient {

    private static final String mBaseUrl = "https://www.googleapis.com/books/v1/";

    private static RestClient instance;

    private Retrofit retrofit;

    private RestClient() { }

    public static RestClient getInstance( ) {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public Retrofit getClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(mBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface GoogleBooksInterface {

        @GET("volumes/{volumeId}")
        Call<Volume> getVolumeById(@Path("volumeId") String volumeId);

        @GET("volumes")
        Call<VolumesResponse> getVolumes(
                @Query("q") String query
        );

    }

}
