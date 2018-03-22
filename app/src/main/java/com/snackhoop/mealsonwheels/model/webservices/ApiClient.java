package com.snackhoop.mealsonwheels.model.webservices;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by malavan on 10/03/18.
 */

public class ApiClient {




    /*URLS

    https://maps.googleapis.com/maps/api/directions/json?origin=place_id:ChIJrc2u8g_1qjsRpq677Tss4G0&destination=place_id:ChIJYTN9T-plUjoRM9RjaAunYW4&key=AIzaSyDR4Npn-9fC7wE0P2js99hn9neh2N3qs08
    */
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/directions/";
    private static Retrofit retrofit = null;




    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                  //  .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
