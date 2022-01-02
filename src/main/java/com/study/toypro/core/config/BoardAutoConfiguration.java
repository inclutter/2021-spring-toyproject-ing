package com.study.toypro.core.config;

import com.study.toypro.core.utilities.JDBCConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class BoardAutoConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Autowired
    JDBCConnectionManagerProperties jdbcConnectionManagerProperties;


    @Bean
    public JDBCConnectionManager getJDBCConnectionManager() {
        System.out.println(jdbcConnectionManagerProperties);
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass(driverClassName);
        manager.setUrl(url);
        manager.setUsername(username);
        manager.setPassword(password);
        return manager;
    }
}
