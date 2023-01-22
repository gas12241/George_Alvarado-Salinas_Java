package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Person jim = new Person("Jim");
        Person callie = new Person();
        callie.setCreatedDate();
        callie.setName("Callie");
        jim.sayHello();
        callie.sayHello();
        System.out.println(jim.getCreatedDate());
        System.out.println(callie.getCreatedDate());

        Filer filer = new Filer();
        filer.storeData();
        filer.retrieveData();
    }
}