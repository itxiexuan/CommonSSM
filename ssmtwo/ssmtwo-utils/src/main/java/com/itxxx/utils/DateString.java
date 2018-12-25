package com.itxxx.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateString {
    public static String date2String(Date date, String formate){
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        String format = sdf.format(date);
        return format;
    }
    public static Date string2Date(String str,String formate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        Date date = sdf.parse(str);
        return date;
    }
}
