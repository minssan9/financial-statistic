package com.financial.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("krbank")
@Data
public class KrBankProperties {
    public  String apikey;
}
