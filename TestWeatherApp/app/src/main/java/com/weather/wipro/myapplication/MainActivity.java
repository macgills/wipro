package com.weather.wipro.myapplication;

import android.os.Bundle;

import com.weather.wipro.myapplication.model.ForecastResponse;
import com.weather.wipro.myapplication.model.ForecastSegment;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements OpenWeatherWeatherRequester.WeatherCallback {

    private WeatherRequester weatherRequester;
    private ForecastView5Day forecastView5Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherRequester = new OpenWeatherWeatherRequester();
        weatherRequester.request5Days(this);
        forecastView5Day = getViewById(R.id.main_forecast_5_day);
    }

    @Override
    public void onWeatherRequestSuccess(ForecastResponse forecastResponse) {
        forecastView5Day.setDayForecastData(getListOfDayForecasts(forecastResponse));
    }

    private List<DayForecast> getListOfDayForecasts(ForecastResponse forecastResponse) {
        List<DayForecast>     dayForecastList  = new ArrayList();
        DayForecast           dayForecast      = new DayForecast(DateTime.now());
        for (ForecastSegment forecastSegment : forecastResponse.getList()) {
            DateTime segmentDateTime = new DateTime(forecastSegment.getDt()*1000L);
            if(segmentDateTime.getDayOfYear() != dayForecast.getDateTime().getDayOfYear()){
                dayForecastList.add(dayForecast);
                dayForecast = new DayForecast(segmentDateTime);
            }
            dayForecast.addSegment(forecastSegment);
        }
        dayForecastList.add(dayForecast);
        return dayForecastList;
    }

    @Override
    public void onWeatherRequestFailure(Throwable t) {

    }
}
