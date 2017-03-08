package com.weather.wipro.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by Jack on 08/03/2017.
 */

public class ForecastView5Day extends RelativeLayout {

    private ForecastViewDay[] forecastViewDays;

    public ForecastView5Day(Context context) {
        this(context, null);
    }

    public ForecastView5Day(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ForecastView5Day(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.forecast_5_day, this);
        forecastViewDays = getForecastViews();
    }

    @NonNull
    private ForecastViewDay[] getForecastViews() {
        return new ForecastViewDay[]{getForecastView(R.id.forecast_day_0),
                                     getForecastView(R.id.forecast_day_1),
                                     getForecastView(R.id.forecast_day_2),
                                     getForecastView(R.id.forecast_day_3),
                                     getForecastView(R.id.forecast_day_4)};
    }

    private ForecastViewDay getForecastView(int forecast_day_0) {
        return (ForecastViewDay) findViewById(forecast_day_0);
    }

    public void setDayForecastData(List<DayForecast> listOfDayForecasts) {
        for (int i = 0; i < forecastViewDays.length; i++) {
            forecastViewDays[i].setDayData(listOfDayForecasts.get(i));
        }
    }
}
