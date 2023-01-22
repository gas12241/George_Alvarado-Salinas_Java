package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountRecordTest {

    @Before
    public void setUp() throws Exception {
        Integer charge1 = 50;
        String chargeDate1 = "12-12-2012";
        AccountRecord ar1= new AccountRecord();
        ar1.setChargeDate(chargeDate1);
        ar1.setCharge(charge1);
    }

    @Test
    public void getCharge() {


    }

    @Test
    public void setCharge() {
    }

    @Test
    public void getChargeDate() {
    }

    @Test
    public void setChargeDate() {
    }
}