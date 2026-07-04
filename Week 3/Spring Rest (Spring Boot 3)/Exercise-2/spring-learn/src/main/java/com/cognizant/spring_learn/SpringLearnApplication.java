package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("--- STARTING: Entering main() method of SpringLearnApplication ---");
        
        // Execute the Hands-On 2 date loading task
        displayDate();
        
        // Start the Spring Boot Web container
        SpringApplication.run(SpringLearnApplication.class, args);
        
        LOGGER.info("--- SUCCESS: SpringBoot Container is fully initialized and running ---");
    }

    public static void displayDate() {
        LOGGER.info("--- START: displayDate() method execution ---");
        
        // 1. Load the standalone XML application context configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        
        // 2. Retrieve the configured bean using the IoC container context
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        
        // 3. Parse the target string value to a standard java.util.Date object
        try {
            Date parsedDate = format.parse("31/12/2018");
            
            System.out.println("\n==============================================");
            System.out.println("SUCCESSFULLY RETRIEVED DATE FROM SPRING CONTEXT:");
            System.out.println("Parsed Date Object Output: " + parsedDate);
            System.out.println("==============================================\n");
            
        } catch (Exception e) {
            LOGGER.error("An error occurred while parsing the date string", e);
        }
        
        LOGGER.info("--- END: displayDate() method execution ---");
    }
}