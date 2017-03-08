package com.weather.wipro.myapplication;

import com.weather.wipro.myapplication.model.ForecastSegment;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 08/03/2017.
 */

class DayForecast {
    private DateTime              dateTime;
    private List<ForecastSegment> forecastSegments = new ArrayList<>();

    public DayForecast(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<ForecastSegment> getForecastSegments() {
        return forecastSegments;
    }

    public DateTime getDateTime() {

        return dateTime;
    }

    public void addSegment(ForecastSegment forecastSegment) {
        forecastSegments.add(forecastSegment);
    }
}
