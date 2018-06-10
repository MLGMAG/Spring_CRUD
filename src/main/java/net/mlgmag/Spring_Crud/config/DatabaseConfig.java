package net.mlgmag.Spring_Crud.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("net.mlgmag.Spring_Crud.repository")
@EnableTransactionManagement
@PropertySource("classpath:properties/database.properties")
public class DatabaseConfig {

    @Resource
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(env.getRequiredProperty("database.entity.package"));
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(getHibernateProperties());

        return entityManagerFactory;
    }

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        BasicDataSource dataSource = new BasicDataSource();
        //DataBase
        URI dbUri = new URI(env.getRequiredProperty("database.uri"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        //Connection Pool
        dataSource.setInitialSize(Integer.valueOf(env.getRequiredProperty("database.initialSize")));
        dataSource.setMinIdle(Integer.valueOf(env.getRequiredProperty("database.minIdle")));
        dataSource.setMaxIdle(Integer.valueOf(env.getRequiredProperty("database.maxIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getRequiredProperty("database.timeBetweenEvictionMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("database.minEvictableIdleTimeMillis")));
        dataSource.setTestOnBorrow(Boolean.valueOf(env.getRequiredProperty("database.testOnBorrow")));
        dataSource.setValidationQuery(env.getRequiredProperty("database.validationQuery"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws URISyntaxException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    private Properties getHibernateProperties() {

        try {

            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("properties/hibernate.properties");
            properties.load(inputStream);

            return properties;

        } catch (IOException e) {
            throw new IllegalArgumentException("Can't find hibernate.properties file:" + e);
        }
    }

}
