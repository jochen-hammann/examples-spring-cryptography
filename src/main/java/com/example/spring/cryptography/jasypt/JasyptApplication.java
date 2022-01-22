package com.example.spring.cryptography.jasypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JasyptApplication implements CommandLineRunner
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    Logger logger = LoggerFactory.getLogger(JasyptApplication.class);

    @Value("${encrypted.property}")
    private String property;

    @Autowired
    private Environment environment;

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    public String getProperty() {
        return property;
    }

    public String getPasswordUsingEnvironment() {
        return this.environment.getProperty("encrypted.property");
    }

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    public static void main(String[] args)
    {
        SpringApplication.run(JasyptApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        logger.info("Encrypted password via getter:             {}.", this.getProperty());
        logger.info("Encrypted password via Spring environment: {}.", this.getPasswordUsingEnvironment());
    }
}
