package com.weather.wipro.myapplication;

import android.support.annotation.NonNull;

import com.weather.wipro.myapplication.model.ForecastResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Jack on 08/03/2017.
 */

public class OpenWeatherWeatherRequester implements WeatherRequester {

    private static final String BASE_URL = "http://api.openweathermap.org";

    @Override
    public void request5Days(final WeatherCallback callback) {
        getOpenWeatherApi().get5DayForecast().enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                callback.onWeatherRequestSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                callback.onWeatherRequestFailure(t);
            }
        });
    }

    private OpenWeatherApi getOpenWeatherApi() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
        return retrofit.create(OpenWeatherApi.class);
    }

    @NonNull
    private OkHttpClient getOkHttpClient() {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            return new OkHttpClient.Builder().addInterceptor(interceptor).build();
        }
        return new OkHttpClient.Builder().build();
    }
}
