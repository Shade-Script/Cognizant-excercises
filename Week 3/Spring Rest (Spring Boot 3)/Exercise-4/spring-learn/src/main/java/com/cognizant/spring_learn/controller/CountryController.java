package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CountryService countryService;

    // Existing endpoint from previous milestone
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("--- START: Entering getCountryIndia() ---");
        Country india = context.getBean("india", Country.class);
        LOGGER.info("--- END: Exiting getCountryIndia() ---");
        return india;
    }

    // New Endpoint: Get country based on path variable code
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("--- START: Entering getCountry() for code: {} ---", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("--- END: Exiting getCountry() ---");
        return country;
    }
}