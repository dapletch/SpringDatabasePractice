package com.spring.jdbc.jdbcproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Seth on 1/18/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.*")
@PropertySource("classpath:jdbc.properties")
public class JdbcPropertiesConfig {

    private Environment env;

    @Autowired
    public JdbcPropertiesConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public JdbcProperties getJdbcProperties() {
        return new JdbcProperties(env.getProperty("jdbc.username"), env.getProperty("jdbc.password")
        , env.getProperty("jdbc.url"), env.getProperty("jdbc.driver"));
    }

}
