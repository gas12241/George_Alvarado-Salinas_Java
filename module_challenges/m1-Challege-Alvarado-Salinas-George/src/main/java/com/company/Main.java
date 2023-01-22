package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main class which will print out negative and positive Customers given
 * a List of String Arrays with pertinent data.
 */
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

    /**
     * Helper method I made to parse the list of String Arrays and return
     * it all as a List of Customers only including every Customer once.
     * @param listOfStringArrays List of String Arrays that will be turned
     *                           into a List of Customers.
     * @return Returns a List of Customers
     */
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

    /**
     * Helper method I made to find the index of the Customer in the List
     * of Customers if it exists.  Should return -1 if the customer is not
     * already in the list.
     * TODO If you could give me some guidance on this method, I would
     * appreciate it.  I don't think this is the most effective way of
     * finding the customer by ID.  I think you could do something like
     * a Binary search as the ID's are in order, and I assume they would be
     * if the sample size was bigger, but I couldn't get the Binary search
     * to work by ID.
     * @param listOfCustomers The listOfCustomers you will be searching
     *                        through.
     * @param id ID you are checking for in the listOfCustomers.
     * @return Returns the index of the Customer given their ID
     * IF it is in the listOfCustomers, else, it will return -1
     */
    public static Integer findIDIndex(List<Customer> listOfCustomers, Integer id) {
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if (listOfCustomers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Takes a listOfCustomers and prints the ones with a positive balance.
     * @param listOfCustomers listOfCustomers you are checking for positive
     *                        balances in.
     */
    public static void printPositiveCustomers(List<Customer> listOfCustomers) {
        List<Customer> positiveCustomers = listOfCustomers.stream()
                .filter(x->x.getBalance() > 0)
                .collect(Collectors.toList());
        for (Customer c : positiveCustomers) {
            System.out.println(c.getName() + "(ID: " +
                               c.getId() + ") has " +
                               String.valueOf(c.getBalance()));
        }
    }

    /**
     * Takes a listOfCustomers and prints the ones with a negative balance.
     * @param listOfCustomers listOfCustomers you are checking for negative
     *                        balances in.
     */
    public static void printNegativeCustomers(List<Customer> listOfCustomers) {
        List<Customer> negativeCustomers = listOfCustomers.stream()
                .filter(x->x.getBalance() < 0)
                .collect(Collectors.toList());
        for (Customer c : negativeCustomers) {
            System.out.println(c.getName() + "(ID: " +
                               c.getId() + ") has " +
                               String.valueOf(c.getBalance()));
        }
    }

    /**
     * Main that will be ran, printing out the positive and negative accounts.
     * @param args arguments given in (I don't think this will be anything
     *             as we aren't taking in anything in the Command Line).
     */
    public static void main(String[] args) {
        //Update this
        // Parses the List of String Arrays and turns it into a List of
        // Customers.
        List<Customer> listOfCustomers = parseListOfStrings(customerData);

        // Prints out positive and negative accounts using the helper methods
        // above.
        // TODO The instructions made it sound like printing the positive and
        // negative accounts was enough.  If you would like a list returned,
        // please let me know and I can do that instead.
        System.out.println("Positive accounts:");
        printPositiveCustomers(listOfCustomers);

        // Using this as a buffer between positive and negative accounts to
        // make it readable
        System.out.println();

        System.out.println("Negative accounts:");
        printNegativeCustomers(listOfCustomers);
    }
}
