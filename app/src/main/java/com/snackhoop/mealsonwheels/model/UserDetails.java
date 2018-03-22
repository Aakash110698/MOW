package com.snackhoop.mealsonwheels.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by malavan on 22/03/18.
 */

public class UserDetails implements Parcelable {
    String name;
    String phone;
    String email;
    String creation_date;
    String city;
    String age;

    public UserDetails() {
    }

    public UserDetails(String name, String phone, String email, String creation_date, String city, String age) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.creation_date = creation_date;
        this.city = city;
        this.age = age;
    }

    protected UserDetails(Parcel in) {
        name = in.readString();
        phone = in.readString();
        email = in.readString();
        creation_date = in.readString();
        city = in.readString();
        age = in.readString();
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeString(email);
        parcel.writeString(creation_date);
        parcel.writeString(city);
        parcel.writeString(age);
    }
}
