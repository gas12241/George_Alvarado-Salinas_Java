package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountRecordTest {

    @Test
    public void getCharge() {
        AccountRecord ar = new AccountRecord();
        Integer charge = 6500;
        String chargeDate = "1-1-21";
        ar.setChargeDate(chargeDate);
        ar.setCharge(charge);
        assertEquals(ar.getCharge(), 6500);
    }

    @Test
    public void setCharge() {
        AccountRecord ar = new AccountRecord();
        Integer charge = 6500;
        String chargeDate = "1-10-21";
        ar.setChargeDate(chargeDate);
        ar.setCharge(charge);

        // Should be 6500
        assertEquals(ar.getCharge(), 6500);

        //set to 10,000
        ar.setCharge(10000);
        assertEquals(ar.getCharge(), 10000);
    }

    @Test
    public void getChargeDate() {
        AccountRecord ar = new AccountRecord();
        Integer charge = 6500;
        String chargeDate = "1-1-21";
        ar.setChargeDate(chargeDate);
        ar.setCharge(charge);
        assertEquals(ar.getChargeDate(), chargeDate);
    }

    @Test
    public void setChargeDate() {
        AccountRecord ar = new AccountRecord();
        Integer charge = 6500;
        String chargeDate = "1-1-21";
        ar.setChargeDate(chargeDate);
        ar.setCharge(charge);

        // Should be 1-1-21 for now
        assertEquals(ar.getChargeDate(), chargeDate);

        // Set to 2-2-12
        String chargeDate2 = "2-2-12";
        ar.setChargeDate(chargeDate2);
        assertEquals(ar.getChargeDate(), chargeDate2);
    }
}