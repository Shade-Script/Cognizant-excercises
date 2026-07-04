package com.cognizant.spring_learn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    
    // Secure signing key requirement for HS256 (Must be at least 256 bits)
    private static final SecretKey SIGNING_KEY = Keys.hmacShaKeyFor(
        "mySecretKeyMustBeAtLeast256BitsLongToSecureHS256Tokens!".getBytes(StandardCharsets.UTF_8)
    );

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(
            @RequestHeader(value = "Authorization", required = false) String authHeader) {
        
        LOGGER.info("--- START: Entering authenticate() ---");

        // Validate if the Authorization header is present and format is Basic
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.error("Authorization header missing or invalid format.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Unauthorized"));
        }

        try {
            // Step 2: Read Authorization header and decode the username and password
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
            
            // credentials format is "username:password"
            String[] values = credentials.split(":", 2);
            if (values.length != 2) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Collections.singletonMap("error", "Invalid header format"));
            }

            String username = values[0];
            String password = values[1];

            LOGGER.info("Attempting authentication for user: {}", username);

            // Match against credential target "user" and "pwd"
            if ("user".equals(username) && "pwd".equals(password)) {
                
                // Step 3: Generate token based on the user retrieved
                String token = generateJwtToken(username);
                
                LOGGER.info("--- END: Exiting authenticate() - Token Generated ---");
                return ResponseEntity.ok(Collections.singletonMap("token", token));
            } else {
                LOGGER.warn("Authentication failed for user: {}", username);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Collections.singletonMap("error", "Unauthorized"));
            }

        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to decode Base64 credentials", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Malformed Base64 payload"));
        }
    }

    private String generateJwtToken(String username) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        // Expiration time set to 15 minutes (900,000 ms)
        Date expiryDate = new Date(nowMillis + 900000); 

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
}