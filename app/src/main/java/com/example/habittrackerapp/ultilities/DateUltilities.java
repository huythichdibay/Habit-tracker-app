package com.example.habittrackerapp.ultilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateUltilities {
    public static List<Date> GetDateListOf2RecentWeek(){
        List<Date> datesList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        for (int i = 0; i < 14; i++) {
            datesList.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }

        Collections.reverse(datesList);

        return datesList;
    }
}
