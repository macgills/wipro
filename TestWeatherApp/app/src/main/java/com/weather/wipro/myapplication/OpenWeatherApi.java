package com.weather.wipro.myapplication;

import com.weather.wipro.myapplication.model.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jack on 08/03/2017.
 */

public interface OpenWeatherApi {

    @GET("data/2.5/forecast?q=London,us&APPID=5df70ca360254f211139ef46ea60ca1b")
    Call<ForecastResponse> get5DayForecast();
}
