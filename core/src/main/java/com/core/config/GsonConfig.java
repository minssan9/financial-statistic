package com.core.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfig {

    @Autowired
    GsonBuilder gsonBuilder;

    @Bean
    Gson GsonConfig(){
        return  gsonBuilder
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES )
                .setPrettyPrinting()
                .create();
    }

}
