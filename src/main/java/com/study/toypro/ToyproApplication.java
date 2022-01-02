package com.study.toypro;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@EnableEncryptableProperties
@ConfigurationPropertiesScan
public class ToyproApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyproApplication.class, args);
    }

}
