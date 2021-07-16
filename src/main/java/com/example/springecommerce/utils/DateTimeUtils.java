package com.example.springecommerce.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final String FORMAT_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd hh:mm:ss";

    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }

    public static String toDateTimeString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD_HHMMSS);
        try {
            return date.format(formatter);
        } catch (Exception e) {
            return null;
        }
    }
}
