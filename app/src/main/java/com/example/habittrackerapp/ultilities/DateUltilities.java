package com.example.habittrackerapp.ultilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateUltilities {
    private static SimpleDateFormat sdf = new SimpleDateFormat();
    public static List<Date> GetDateListOf2RecentWeek(){
        List<Date> datesList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 20; i++) {
            datesList.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }

        Collections.reverse(datesList);

        return datesList;
    }

    public static Date StringToDate(String format, String date){
        sdf.applyPattern(format);
        Date date1 = new Date();
        try {
            date1 = sdf.parse(date);
        } catch (ParseException e) {
            return new Date(2002 - 1900, 9, 21);
        }
        return date1;
    }
    public static String FormatDate(String format, Date date){
        sdf.applyPattern(format);

        return sdf.format(date);
    }
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }
}
