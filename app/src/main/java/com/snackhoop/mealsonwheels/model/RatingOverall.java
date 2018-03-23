
package com.snackhoop.mealsonwheels.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingOverall {

    @SerializedName("food")
    @Expose
    private Integer food;
    @SerializedName("look_and_feel")
    @Expose
    private Integer look_and_feel;
    @SerializedName("service")
    @Expose
    private Integer service;

    public RatingOverall() {
    }

    public RatingOverall(Integer food, Integer look_and_feel, Integer service) {
        this.food = food;
        this.look_and_feel = look_and_feel;
        this.service = service;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getLook_and_feel() {
        return look_and_feel;
    }

    public void setLook_and_feel(Integer look_and_feel) {
        this.look_and_feel = look_and_feel;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }
}
