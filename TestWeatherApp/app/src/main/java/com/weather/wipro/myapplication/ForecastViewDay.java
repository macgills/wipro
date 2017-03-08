package com.weather.wipro.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weather.wipro.myapplication.model.ForecastSegment;

/**
 * Created by Jack on 08/03/2017.
 */

public class ForecastViewDay extends LinearLayout {

    private final DateFormatter dateFormatter = new DateFormatter();
    private final LinearLayout root;
    private TextView title;

    public ForecastViewDay(Context context) {
        this(context, null);
    }

    public ForecastViewDay(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ForecastViewDay(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.forecast_day_view, this);
        title = (TextView) findViewById(R.id.day_title);
        root = (LinearLayout) findViewById(R.id.day_root);
    }

    public void setDayData(DayForecast dayForecast) {
        title.setText((dateFormatter.formaToWeekday(dayForecast.getDateTime())));
        for (ForecastSegment forecastSegment : dayForecast.getForecastSegments()) {
            root.addView(new ForecastViewSegment(getContext(),forecastSegment));
        }
    }
}
