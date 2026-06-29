package com.cognizant.orm_learn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    private static CountryService countryService;
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        // Fetch Beans from Context
        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        
        // Run Tests
        testGetAllCountries();
        testAddEmployee();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start - Country Test");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End - Country Test");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start - Employee Add Test");
        
        // Creating a test dummy employee instance
        Employee newEmp = new Employee("Aditya Yadav");
        
        LOGGER.debug("Saving employee: {}", newEmp.getName());
        employeeService.addEmployee(newEmp);
        
        // The ID gets populated automatically after save due to GenerationType.IDENTITY
        LOGGER.info("Employee saved successfully! Generated ID: {}", newEmp.getId());
        LOGGER.info("End - Employee Add Test");
    }
}