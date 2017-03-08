package com.weather.wipro.myapplication;

import com.weather.wipro.myapplication.model.ForecastResponse;

/**
 * Created by Jack on 08/03/2017.
 */

public interface WeatherRequester {
    void request5Days(OpenWeatherWeatherRequester.WeatherCallback callback);

    interface WeatherCallback {
        void onWeatherRequestSuccess(ForecastResponse forecastResponse);

        void onWeatherRequestFailure(Throwable t);
    }
}
