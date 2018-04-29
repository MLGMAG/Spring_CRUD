package net.mlgmag.Spring_Crud.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;

@Configuration
@EnableMongoRepositories("net.mlgmag.Spring_Crud.repository")
@PropertySource("classpath:database.properties")
public class DatabaseConfig extends AbstractMongoConfiguration {

    @Resource
    private Environment environment;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(
                String.valueOf(environment.getRequiredProperty("database.host")),
                Integer.valueOf(environment.getRequiredProperty("database.port")));
    }

    @Override
    protected String getDatabaseName() {
        return String.valueOf(environment.getRequiredProperty("database.name"));
    }

}
