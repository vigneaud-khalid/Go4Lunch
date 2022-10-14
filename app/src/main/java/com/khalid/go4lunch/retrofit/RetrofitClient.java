package com.khalid.go4lunch.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author khalid
 */
public class RetrofitClient {

    private static Retrofit retrofit;

//Define the base URL//

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

//Create the Retrofit instance, add the converter & build the Retrofit instance
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
//                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
