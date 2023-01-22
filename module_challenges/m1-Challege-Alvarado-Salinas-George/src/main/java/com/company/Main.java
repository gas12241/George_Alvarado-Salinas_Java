package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static List<Customer> parseListOfStrings(List<String[]> listOfStringArrays) {
        List<Customer> listOfCustomers = new ArrayList<>();
        for (String[] stringArray : listOfStringArrays) {
            Integer id = Integer.valueOf(stringArray[0]);
            String name = stringArray[1];
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            Integer charge = Integer.valueOf(stringArray[2]);
            String chargeDate = stringArray[3];
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(charge);
            accountRecord.setChargeDate(chargeDate);
            Integer idIndex = findIDIndex(listOfCustomers, id);
            if (idIndex != -1) {
                listOfCustomers.get(idIndex).getCharges().add(accountRecord);
                continue;
            }
            customer.getCharges().add(accountRecord);
            listOfCustomers.add(customer);
        }
        return listOfCustomers;
    }

    public static Integer findIDIndex(List<Customer> listOfCustomers, Integer id) {
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if (listOfCustomers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Update this
        List<Customer> listOfCustomers = parseListOfStrings(customerData);
        System.out.println("Positive accounts:");
        List<Customer> positiveCustomers = listOfCustomers.stream()
                .filter(x->x.getBalance() > 0)
                .collect(Collectors.toList());
        System.out.println(positiveCustomers);
        System.out.println("Negative accounts:");
        List<Customer> negativeCustomers = listOfCustomers.stream()
                .filter(x->x.getBalance() < 0)
                .collect(Collectors.toList());
        System.out.println(negativeCustomers);
        System.out.println("All customers");
        System.out.println(listOfCustomers);
    }
}
