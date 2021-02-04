package com.voyagerss.financial.config;

import lombok.Data;
import lombok.Getter;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("krbank")
@Data
public class KrBankProperties {
    public  String apikey;
}
