package com.core.config;


import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class StaticConfig {
    public static DateTimeFormatter DATE_STRING_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter TIME_STRING_FORMAT = DateTimeFormatter.ofPattern("HHmm");

    public static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

}
