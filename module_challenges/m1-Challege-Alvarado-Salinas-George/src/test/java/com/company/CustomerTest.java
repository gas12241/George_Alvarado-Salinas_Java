package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CustomerTest {

    @org.junit.Test
    public void getId() {
    }

    @org.junit.Test
    public void setId() {

    }

    @org.junit.Test
    public void getName() {
    }

    @org.junit.Test
    public void setName() {
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

        c1.getCharges().add(ar1);
        assertEquals(2500, c1.getBalance());
    }

    @org.junit.Test
    public void getCharges() {
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
    }
}