package com.company;

/**
 * AccountRecord class that will be used to track charges made to a
 * Customer.
 */
public class AccountRecord {
    private int charge;
    private String chargeDate;

    /**
     * Getter for the AccountRecord charge.
     * @return Returns an Integer of how big the charge was.
     */
    public int getCharge() {
        return charge;
    }

    /**
     * Setter for the AccountRecord charge.
     * @param charge Integer which will be used to set the new charge amount.
     */
    public void setCharge(int charge) {
        this.charge = charge;
    }

    /**
     * Getter for the AccountRecord chargeDate.
     * @return Returns a String of the date of the charge.
     */
    public String getChargeDate() {
        return chargeDate;
    }

    /**
     * Setter for the chargeDate
     * @param chargeDate String which will be used to set the new chargeDate.
     */
    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }
}
