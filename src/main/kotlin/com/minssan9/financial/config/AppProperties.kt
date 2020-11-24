package com.minssan9.financial.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("account")
class AppProperties {

//    @Value("\${krbankkey}")
    val krbankkey: String = "A3KS6JOGXDYWDBC2XQ3Y"
}
