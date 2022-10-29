package com.hvs.lab.spring;

import com.hvs.lab.spring.config.AppConfig;
import com.hvs.lab.spring.service.PostilionInterfaceSimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
        @PropertySource("classpath:application-additional.yml")
})
public class CommandRunner implements CommandLineRunner {


    @Value("${app-name}")
    private String appName;
    @Value("${app-name-2}")
    private String appName2;

    @Autowired
    private PostilionInterfaceSimulator simulator;
    @Autowired
    private AppConfig config;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(String.format("AppNMame: %s", appName));
        System.out.println(String.format("AppNMame2: %s", appName2));

        System.out.println(config.getName());
        System.out.println(config.getTest());


        simulator.startProcess();

    }
}
