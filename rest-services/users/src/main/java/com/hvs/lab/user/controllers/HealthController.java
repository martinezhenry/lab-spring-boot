package com.hvs.lab.user.controllers;

import com.hvs.lab.user.exceptions.UserNotFoundException;
import com.hvs.lab.user.exceptions.UserNotModifiedException;
import com.hvs.lab.user.models.User;
import com.hvs.lab.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@RestController
public class HealthController {

    @Value("${scope}")
    private String scope;

    @Value("${tags}")
    private String tags;

    @GetMapping("health/scope")
    public String getUser() throws UserNotFoundException {
        return this.scope;
    }

    @GetMapping("health/db-name")
    public String getDbName() throws UserNotFoundException {
        return System.getenv("ENV_DB_NAME");
    }

    @GetMapping("health/tags")
    public String getDbName(@PathVariable String text) throws UserNotFoundException, IOException {
        return this.tags;
    }

    @GetMapping("health/read-file")
    public List<String> getFile(@PathVariable String text) throws IOException {
        return Files.readAllLines(Paths.get("./image.txt"));
    }

}
