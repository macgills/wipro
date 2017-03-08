package com.weather.wipro.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weather.wipro.myapplication.model.ForecastSegment;

/**
 * Created by Jack on 08/03/2017.
 */

class ForecastViewSegment extends LinearLayout {
    public ForecastViewSegment(Context context, ForecastSegment forecastSegment) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.forecast_segment_view, this);
        TextView time = (TextView) findViewById(R.id.segment_time);
        time.setText(forecastSegment.getDtTxt().split(" ")[1]);
        TextView summary = (TextView) findViewById(R.id.segment_summary);
        summary.setText(forecastSegment.getWeather().get(0).getMain());
    }
}
