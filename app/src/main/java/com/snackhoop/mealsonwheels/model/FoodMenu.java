package com.snackhoop.mealsonwheels.model;

/**
 * Created by malavan on 23/03/18.
 */

public class FoodMenu {
    String img_url;
    String name;
    String type;
    String rate;
    String uid;
    String quatity;
    String desc;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FoodMenu() {
    }

    public FoodMenu(String img_url, String name, String type, String rate, String uid, String quatity, String desc) {
        this.img_url = img_url;
        this.name = name;
        this.type = type;
        this.rate = rate;
        this.uid = uid;
        this.quatity = quatity;
        this.desc = desc;
    }
}
