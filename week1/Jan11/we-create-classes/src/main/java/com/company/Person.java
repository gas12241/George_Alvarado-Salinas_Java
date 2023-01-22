package com.company;

import java.util.Date;

public class Person {
    // State
    private String name;

    private Date createdDate;

    // Constructors
    public Person() {
    }
    public Person(String name) {
        this.name = name;
        this.createdDate = new Date();
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedDate() {
        this.createdDate = new Date();
    }

    // Behaviour
    public void sayHello() {
        System.out.println("Hello, I am " + this.name);
    }
}
