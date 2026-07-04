package com.cognizant.spring_learn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.spring_learn.model.Country;

@Service
public class CountryService {

    @Autowired
    private ApplicationContext context;

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) {
        // Retrieve the countryList bean from context
        List<Country> countries = context.getBean("countryList", List.class);

        // Filter through the list matching code case-insensitively
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); 
    }
}