package com.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "db-mysql")
@Configuration
@Getter
@Setter
public class MysqlProperties   {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
