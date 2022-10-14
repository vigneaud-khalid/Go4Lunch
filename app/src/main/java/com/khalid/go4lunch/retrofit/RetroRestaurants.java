package com.khalid.go4lunch.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * @author khalid
 */
public class RetroRestaurants {
//Give the field a custom name//

    @SerializedName("name")
    private String name;

    public RetroRestaurants(String name) {
        this.name = name;

    }

//Retrieve the data using setter/getter methods//

    public String getRestaurant() {
        return name;
    }

    public void setRestaurant(String name) {
        this.name = name;
    }

}
