package com.core;

import com.core.properties.MysqlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
public class CoreApplicationTests {
    @Autowired
    MysqlProperties mysqlProperties;
    public void contextLoads(){
        System.out.println(mysqlProperties);
    }
}
