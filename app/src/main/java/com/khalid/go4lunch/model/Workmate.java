package com.khalid.go4lunch.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author khalid
 */
public class Workmate implements Serializable {

    private String firstName;
    private String name;
    private String photo;
    private HashMap ratings;
    private long recomandedResto;

    public Workmate() {
    }

    public Workmate(String firstName, String name, String photo, HashMap ratings, long recomandedResto) {
        this.firstName = firstName;
        this.name = name;
        this.photo = photo;
        this.ratings = ratings;
        this.recomandedResto = recomandedResto;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public HashMap getRatings() {
        return ratings;
    }

    public void setRatings(HashMap ratings) {
        this.ratings = ratings;
    }

    public long getRecomandedResto() {
        return recomandedResto;
    }

    public void setRecomandedResto(long recomandedResto) {
        this.recomandedResto = recomandedResto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workmate workmate = (Workmate) o;
        return recomandedResto == workmate.recomandedResto && firstName.equals(workmate.firstName) && name.equals(workmate.name) && photo.equals(workmate.photo) && ratings.equals(workmate.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, name, photo, ratings, recomandedResto);
    }
}
