package com.khalid.go4lunch.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author khalid
 */
public interface GetData {

//Specify the request type and pass the relative URL
    @GET("/restaurants")

//Wrap the response in a Call object with the type of the expected result
    Call<List<RetroRestaurants>> getAllRestaurants();
}
