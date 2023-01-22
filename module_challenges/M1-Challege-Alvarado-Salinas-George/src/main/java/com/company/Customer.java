package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class which has an ID, a Name, and a List of charges noted
 * as a List of AccountRecord(s).
 */
public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    /**
     * Getter for the Customer ID.
     * @return Returns and Integer of the Customer ID.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter for the Customer ID.
     * @param id What the ID for the Customer will be set to.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the Customer Name.
     * @return Returns a String of the Customer's Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the Customer Name.
     * @param name What the Name for the Customer will be set to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Balance for the Customer's account by going through
     * the Customer's List of AccountRecords and adding up the charges.
     * @return Returns an Integer, the sum of the charges in the Customer's
     *         List of AccountRecord(s)
     */
    public int getBalance() {
        Integer balance = 0;
        for (AccountRecord ar : this.charges) {
            balance += ar.getCharge();
        }
        return balance;
    }

    /**
     * Gets the List of AccountRecord(s) of the customer.
     * @return Returns the List of AccountRecord(s) of the customer.
     */
    public List<AccountRecord> getCharges() {
        return this.charges;
    }

    /**
     * toString of a Customer which tells us the Customer
     * Information (ID, Name and Balance)
     * @return Returns a String version of the object, letting us know
     *         the Customer ID, Name, and Balance.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", balance=" + this.getBalance() +
                '}';
    }
}
