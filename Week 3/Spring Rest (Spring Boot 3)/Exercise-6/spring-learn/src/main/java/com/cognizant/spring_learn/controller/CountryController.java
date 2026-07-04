package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.model.Country;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // Injecting the underlying application context to fetch XML-defined beans
    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("--- START: Entering getCountryIndia() REST endpoint ---");
        
        // Fetching the pre-configured bean from the XML context
        Country india = context.getBean("india", Country.class);
        
        LOGGER.info("Successfully fetched bean: {}", india);
        LOGGER.info("--- END: Exiting getCountryIndia() REST endpoint ---");
        return india;
    }
}