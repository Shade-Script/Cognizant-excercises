package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Handles MySQL AUTO_INCREMENT
    @Column(name="em_id")
    private Integer id;

    @Column(name="em_name")
    private String name;

    // Default Constructor
    public Employee() {}

    // Parameterized Constructor for easy testing
    public Employee(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}