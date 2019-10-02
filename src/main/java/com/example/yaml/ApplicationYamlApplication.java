package com.example.yaml;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ApplicationYamlApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new ApplicationYamlApplication()
                .configure(new SpringApplicationBuilder(ApplicationYamlApplication.class)).run(args);
    }
}
