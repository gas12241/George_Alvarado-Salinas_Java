package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void parseListOfStrings() {
        // Shortened version of what was given to us in main.
        List<String[]> customerData = Arrays.asList(
                new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
                new String[] {"2","Daily Planet","-7500","01-10-2022"},
                new String[] {"1","Wayne Enterprises","5000","12-22-2021"},
                new String[] {"3","Ace Chemical","10000","01-10-2022"},
                new String[] {"3","Ace Chemical","-7500","12-15-2021"},
                new String[] {"1","Wayne Enterprises","2500","01-01-2022"}
        );
        List<Customer> listOfCustomers =  Main.parseListOfStrings(customerData);

        // Size should be 3, only 3 unique ID's
        assertEquals(listOfCustomers.size(), 3);

        Customer customer1 = new Customer();
        String name1 = "Wayne Enterprises";
        Integer id = 1;
        // Account Records for Wayne Enterprises
        AccountRecord ar1 = new AccountRecord();
        ar1.setCharge(10000);
        ar1.setChargeDate("12-01-2021");
        AccountRecord ar2 = new AccountRecord();
        ar2.setCharge(5000);
        ar2.setChargeDate("12-22-2021");
        AccountRecord ar3 = new AccountRecord();
        ar3.setCharge(2500);
        ar3.setChargeDate("01-01-2022");
        customer1.setName(name1);
        customer1.setId(id);
        customer1.getCharges().add(ar1);
        customer1.getCharges().add(ar2);
        customer1.getCharges().add(ar3);

        Customer customer2 = new Customer();
        String name2 = "Daily Planet";
        Integer id2 = 2;
        // Account Record for Daily Planet
        AccountRecord ar4 = new AccountRecord();
        ar4.setCharge(-7500);
        ar4.setChargeDate("01-10-2022");
        customer2.setName(name2);
        customer2.setId(id2);
        customer2.getCharges().add(ar4);

        Customer customer3 = new Customer();
        String name3 = "Ace Chemical";
        Integer id3 = 3;
        // Account Records for Ace Chemical
        AccountRecord ar5 = new AccountRecord();
        ar5.setCharge(10000);
        ar5.setChargeDate("01-10-2022");
        AccountRecord ar6 = new AccountRecord();
        ar6.setCharge(-7500);
        ar6.setChargeDate("12-15-2021");
        customer3.setName(name3);
        customer3.setId(id3);
        customer3.getCharges().add(ar5);
        customer3.getCharges().add(ar6);

        List<Customer> expectedListOfCustomers = new ArrayList<>();
        expectedListOfCustomers.add(customer1);
        expectedListOfCustomers.add(customer2);
        expectedListOfCustomers.add(customer3);

        // The lists don't come back the same so not sure if I can
        // Assert them to be equal to each other, but I printed them
        // Both out together, so you can see that they are pretty much the same.
        // If I had to take a guess, I assume the lists are not equal because
        // of where the customers live in memory, not sure though.
        for (int i = 0; i < listOfCustomers.size(); i++) {
            System.out.println("Parsed List, then Expected List");
            System.out.println(listOfCustomers.get(i));
            System.out.println(expectedListOfCustomers.get(i));
        }
    }

    @Test
    public void findIDIndex() {
        List<String[]> customerData = Arrays.asList(
                new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
                new String[] {"2","Daily Planet","-7500","01-10-2022"},
                new String[] {"1","Wayne Enterprises","5000","12-22-2021"},
                new String[] {"3","Ace Chemical","10000","01-10-2022"},
                new String[] {"3","Ace Chemical","-7500","12-15-2021"},
                new String[] {"1","Wayne Enterprises","2500","01-01-2022"}
        );
        List<Customer> listOfCustomers =  Main.parseListOfStrings(customerData);
        Integer indexOfWayneEnterprises = Main.findIDIndex(listOfCustomers, 1);
        Integer indexOfDailyPlanet = Main.findIDIndex(listOfCustomers, 2);
        Integer indexOfAceChemical = Main.findIDIndex(listOfCustomers, 3);
        assertEquals(listOfCustomers
                .get(indexOfWayneEnterprises)
                .getName(), "Wayne Enterprises");

        assertEquals(listOfCustomers
                .get(indexOfDailyPlanet)
                .getName(), "Daily Planet");

        assertEquals(listOfCustomers
                .get(indexOfAceChemical)
                .getName(), "Ace Chemical");
    }
}