package com.service.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.host}")
    String archiveHostName;
    @Value("${spring.data.mongodb.database}")
    String archiveDatabaseName;

    @Bean
    @Primary
    public SimpleMongoClientDatabaseFactory mongoDbFactory(){
        return new SimpleMongoClientDatabaseFactory(mongoClient(), archiveDatabaseName);
    }

    public MongoClient mongoClient() {
        ConnectionString connString= new ConnectionString(archiveHostName);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        return MongoClients.create(settings);
    }

    @Bean(name = "mongoTemplate")
    @Primary
    public MongoTemplate mongoTemplate()  {
        return new MongoTemplate(mongoDbFactory());
    }


//    @Bean
//    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory) {
//        return new MongoTemplate(mongoDatabaseFactory);
//    }
//
//    @Bean
//    public MongoDatabaseFactory mongoDatabaseFactory(MongoProperties mongoProperties) {
//        return new SimpleMongoClientDatabaseFactory(mongoProperties.getHost());
//    }
}
