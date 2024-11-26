package com.example.weatherapp; // Adjust the package name as per your project structure

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/"; // Corrected the URL format
    private static Retrofit retrofit;

    // Public method to get Retrofit client
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // Set the base URL
                    .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter
                    .build();
        }
        return retrofit;
    }
}
