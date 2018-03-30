package com.ottoboni.interview.data.remote;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by caoj on 28/03/18.
 */

public class ApiClient {

    private final static String API_BASE_URL = "https://api.github.com";

    private static OkHttpClient client = new OkHttpClient();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    /**
     * Create requests api request.
     *
     * @return the api request
     */
    public static ApiRequest createRequests() {
        Retrofit retrofit = builder.client(client)
                .build();
        return retrofit.create(ApiRequest.class);
    }
}
