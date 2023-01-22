package com.company.studentservice.models;

public class Student {
    // state variables
    private String name;

    public Student(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
