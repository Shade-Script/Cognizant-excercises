package com.cognizant.spring_learn.model;

public class Country {
    private String code;
    private String name;

    // No-arg constructor required for instantiation frameworks
    public Country() {}

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and Setters (Crucial for Jackson Serialization)
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}