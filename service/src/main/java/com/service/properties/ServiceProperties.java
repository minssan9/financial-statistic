package com.service.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//@Configuration
//@ConfigurationProperties(prefix = "app")
@Component
public class ServiceProperties {
    @Value("${ecos-api-key}")
    private  String ecosApiKey;

    public String getEcosApiKey(){
        return this.ecosApiKey;
    }
    public void setEcosApiKey(@Value("${ecos-api-key}") String ecosApiKey) {
        this.ecosApiKey = ecosApiKey;
    }
}
