package com.weather.wipro.myapplication;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by Jack on 08/03/2017.
 */

public class DateFormatter {
    public String formaToWeekday(DateTime dateTime) {
        DateTime now = DateTime.now();
        int      dayOfYearToFormat = dateTime.getDayOfYear();
        int      currentDayOfYear = now.getDayOfYear();
        if (dayOfYearToFormat == currentDayOfYear){
            return "Now";
        }
        if(dayOfYearToFormat - currentDayOfYear == 1){
            return "Tomorrow";
        }
        return DateTimeFormat.forPattern("EEEE").print(dateTime);
    }
}
