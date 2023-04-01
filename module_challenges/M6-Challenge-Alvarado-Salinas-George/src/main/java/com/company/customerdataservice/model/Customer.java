package com.company.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * Customer model for this project. This is the object that will be used in the DB.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer implements Serializable {

    /**
     * Fields for a Customer Object.
     */
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String company;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;

    /**
     * Getter for the Id of a Customer Object.
     * @return Returns an Integer, id, for a Customer Object.
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Setter for the Id of a Customer Object.
     * @param customerId Integer parameter that will be use to set
     *                   the Id of the Customer Object.
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for the firstName of a Customer Object.
     * @return Returns a String of the firstName of
     *         a Customer Object.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the firstName of a Customer Object.
     * @param firstName String that will be used to set
     *                  the firstName of the Object.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the lastName of a Customer Object.
     * @return Returns a String of the lastName of the
     *         Object.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the lastName of a Customer Object.
     * @param lastName String that will be used to set
     *                 the lastName of the Object.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the email of a Customer Object.
     * @return Returns a String of the email of
     *         the Customer Object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email of a Customer Object.
     * @param email String that will be used to set
     *              the email of the Customer Object.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the company of a Customer Object.
     * @return Returns a String of company of the
     *         Customer Object.
     */
    public String getCompany() {
        return company;
    }

    /**
     * Setter for the company of a Customer Object.
     * @param company String used to set the company
     *                for the Customer Object.
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Getter for the phone of a Customer Object.
     * @return Returns a String of the phone of
     *         a Customer Object.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for the phone of a Customer Object.
     * @param phone String used to set the phone for
     *              Customer Object.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for the address1 of a Customer Object.
     * @return Returns a String of the address1 of a
     *         Customer Object.
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Setter for the address1 of a Customer Object.
     * @param address1 String used to set the address1
     *                 for a Customer Object.
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Getter for address2 of a Customer Object.
     * @return Returns a String of the address2 of the
     *         Customer Object.
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Setter for address2 of a Customer Object.
     * @param address2 String used to set address2
     *                 for a Customer Object.
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Getter for the city of a Customer Object.
     * @return Returns a String of the city of
     *         a Customer Object.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the city of a Customer Object.
     * @param city String used to set the city
     *             for a Customer Object.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for the state of a Customer Object.
     * @return Returns a String of the state of
     *         a Customer Object.
     */
    public String getState() {
        return state;
    }

    /**
     * Setter for the state of a Customer Object.
     * @param state String used to set the state
     *              of a Customer Object.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for the postalCode of a Customer Object.
     * @return Returns the String of the postalCode
     *         of the Customer Object.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Setter for the postalCode of the Customer Object.
     * @param postalCode String used to set the postalCode
     *                   for the Customer Object.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Getter for the Country of a Customer Object.
     * @return Returns the String of the country
     *         of the Customer Object.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for the country of a Customer Object.
     * @param country String used to set the country
     *                of a Customer object.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * equals for the Customer Object.
     * @param o Object o used to test equality.
     * @return Returns true if the object being compared
     *         to is equal to the object calling the method.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getCustomerId(), customer.getCustomerId()) && Objects.equals(getFirstName(), customer.getFirstName()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getEmail(), customer.getEmail()) && Objects.equals(getCompany(), customer.getCompany()) && Objects.equals(getPhone(), customer.getPhone()) && Objects.equals(getAddress1(), customer.getAddress1()) && Objects.equals(getAddress2(), customer.getAddress2()) && Objects.equals(getCity(), customer.getCity()) && Objects.equals(getState(), customer.getState()) && Objects.equals(getPostalCode(), customer.getPostalCode()) && Objects.equals(getCountry(), customer.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getFirstName(), getLastName(), getEmail(), getCompany(), getPhone(), getAddress1(), getAddress2(), getCity(), getState(), getPostalCode(), getCountry());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}