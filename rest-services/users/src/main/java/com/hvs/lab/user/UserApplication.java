package com.hvs.lab.user;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@Slf4j
public class UserApplication {

    @Value("${scope}")
    private static String scope;
    public static void main(String[] args) throws IOException {
        SpringApplication.run(UserApplication.class, args);
    }
}
