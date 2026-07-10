package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoadCountryApplication - exposes the country bean from XML as a REST endpoint.
 */
@SpringBootApplication
@RestController
public class LoadCountryApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadCountryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoadCountryApplication.class, args);
    }

    @GetMapping("/country")
    public Country getCountry() {
        LOGGER.info("Request received for /country");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country = context.getBean("country", Country.class);
            LOGGER.info("Returning country: {}", country);
            return country;
        }
    }
}
