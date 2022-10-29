package com.hvs.lab.spring.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "config")
@Configuration
@Data
public class AppConfig {
    private String name;
    private String test = "hola";
}
