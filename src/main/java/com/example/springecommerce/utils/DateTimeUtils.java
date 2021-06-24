package com.example.springecommerce.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtils {
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }
}
