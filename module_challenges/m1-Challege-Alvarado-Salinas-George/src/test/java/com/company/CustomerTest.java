package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CustomerTest {

    @org.junit.Test
    public void getId() {
        Customer customer = new Customer();
        String name = "Warner Bros";
        Integer id = 5;
        customer.setName(name);
        customer.setId(id);
        assertEquals(5, customer.getId());
    }

    @org.junit.Test
    public void setId() {
        Customer customer = new Customer();
        String name = "Warner Bros";
        Integer id = 5;
        customer.setName(name);
        customer.setId(id);
        //Expect 5 here
        assertEquals(5, customer.getId());

        // Expect 25 here
        Integer id2 = 25;
        customer.setId(id2);
        assertEquals(25, customer.getId());
    }

    @org.junit.Test
    public void getName() {
        Customer customer = new Customer();
        String name = "Justice League";
        Integer id = 70;
        customer.setName(name);
        customer.setId(id);

        assertEquals("Justice League", customer.getName());
    }

    @org.junit.Test
    public void setName() {
        Customer customer = new Customer();
        String name = "Six Flags";
        Integer id = 100;
        customer.setName(name);
        customer.setId(id);
        //Expect Six Flags here
        assertEquals("Six Flags", customer.getName());

        // Expect Nike here
        String name2 = "Nike";
        customer.setName(name2);
        assertEquals("Nike", customer.getName());
    }


    @org.junit.Test
    public void getPositiveBalance() {
        Integer id1 = 1;
        String name1 = "George";
        Customer c1 = new Customer();
        c1.setId(id1);
        c1.setName(name1);
        Integer charge1 = 2500;
        String chargeDate1 = "12-12-12";
        AccountRecord ar1 = new AccountRecord();
        ar1.setCharge(charge1);
        ar1.setChargeDate(chargeDate1);


        AccountRecord ar2 = new AccountRecord();
        Integer charge2 = 7500;
        String chargeDate2 = "1-1-12";
        ar2.setChargeDate(chargeDate2);
        ar2.setCharge(charge2);

        // Added 2500 and 7500 charges
        c1.getCharges().add(ar1);
        c1.getCharges().add(ar2);
        assertEquals(10000, c1.getBalance());
    }

    @org.junit.Test
    public void getNegativeBalance() {
        Integer id1 = 1;
        String name1 = "George";
        Customer c1 = new Customer();
        c1.setId(id1);
        c1.setName(name1);
        Integer charge1 = -2500;
        String chargeDate1 = "12-12-12";
        AccountRecord ar1 = new AccountRecord();
        ar1.setCharge(charge1);
        ar1.setChargeDate(chargeDate1);


        AccountRecord ar2 = new AccountRecord();
        Integer charge2 = -7500;
        String chargeDate2 = "1-1-12";
        ar2.setChargeDate(chargeDate2);
        ar2.setCharge(charge2);

        // Added -2500 and -7500 charges
        c1.getCharges().add(ar1);
        c1.getCharges().add(ar2);
        assertEquals(-10000, c1.getBalance());
    }

    @org.junit.Test
    public void getNoBalance() {
        Integer id1 = 1;
        String name1 = "George";
        Customer c1 = new Customer();
        c1.setId(id1);
        c1.setName(name1);

        // Nothing was added to the list of Account Records for the customer
        // So we should get 0 back.
        assertEquals(0, c1.getBalance());
    }

    @org.junit.Test
    public void getCharges() {
        AccountRecord ar1 = new AccountRecord();
        Integer charge1 = 500;
        String chargeDate1 = "12-12-12";
        ar1.setCharge(charge1);
        ar1.setChargeDate(chargeDate1);

        AccountRecord ar2 = new AccountRecord();
        Integer charge2 = 500;
        String chargeDate2 = "12-12-12";
        ar2.setCharge(charge2);
        ar2.setChargeDate(chargeDate2);

        AccountRecord ar3 = new AccountRecord();
        Integer charge3 = 500;
        String chargeDate3 = "12-12-12";
        ar3.setCharge(charge3);
        ar3.setChargeDate(chargeDate3);

        Customer customer = new Customer();
        Integer id = 42;
        String name = "Nintendo";
        customer.setId(id);
        customer.setName(name);
        customer.getCharges().add(ar1);
        customer.getCharges().add(ar2);
        customer.getCharges().add(ar3);
        List<AccountRecord> accountRecordList = new ArrayList<>();
        accountRecordList.add(ar1);
        accountRecordList.add(ar2);
        accountRecordList.add(ar3);

        // Comparing the charges to a list with the same objects in it
        assertEquals(customer.getCharges(), accountRecordList);
    }

    @org.junit.Test
    public void testToString() {
        Integer id1 = 1;
        String name1 = "George";
        Integer charge1 = 2500;
        String chargeDate1 = "12-12-12";
        AccountRecord ar1 = new AccountRecord();
        ar1.setCharge(charge1);
        ar1.setChargeDate(chargeDate1);

        Customer c1 = new Customer();
        c1.setId(id1);
        c1.setName(name1);

        Customer c2 = new Customer();
        c2.setId(id1);
        c2.setName(name1);

        Customer c3 = new Customer();
        c3.setId(id1);
        c3.setName(name1);

        // Testing a to a
        assertEquals(c1.toString(), c1.toString());

        // Testing a to b and b to a
        assertEquals(c1.toString(), c2.toString());
        assertEquals(c2.toString(), c1.toString());

        // Testing a to b, b to c, then a to c
        assertEquals(c1.toString(), c2.toString());
        assertEquals(c2.toString(), c3.toString());
        assertEquals(c1.toString(), c3.toString());
    }
}