package com.core.config;


import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class StaticConfig {
    public static DateTimeFormatter dateFormatString = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter timeFormatString = DateTimeFormatter.ofPattern("HHmm");

    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

}
