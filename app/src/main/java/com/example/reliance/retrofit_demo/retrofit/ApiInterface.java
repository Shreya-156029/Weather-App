package com.example.reliance.retrofit_demo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?&appid=3b427adf60ee2f64c798c3921f233032&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);
}
