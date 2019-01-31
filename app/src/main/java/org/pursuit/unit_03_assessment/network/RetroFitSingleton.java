package org.pursuit.unit_03_assessment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitSingleton {
    private static Retrofit instance;

    private RetroFitSingleton(){}

    public static Retrofit getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new Retrofit.Builder()
                /**
                 * this url string should end with an / and your servce interface urls should not begin with a /
                 */
                    .baseUrl("https://raw.githubusercontent.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
