package com.company.customerdataservice.repository;

import com.company.customerdataservice.CustomerDataServiceApplication;
import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerDataServiceApplication.class)
public class CustomerRepositoryTest {

    //@MockBean
    @Autowired
    CustomerRepository customerRepo;

    Customer customer;
    Customer customer2;
    Customer customer3;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
        customer = new Customer();
        customer.setFirstName("Kobe");
        customer.setLastName("Bryant");
        customer.setEmail("KB24@gmail.com");
        customer.setCompany("Los Angeles Lakers");
        customer.setPhone("2123934567");
        customer.setAddress1("1111 11th ave sw");
        customer.setAddress2("2222 22th ave sw");
        customer.setCity("Los Angeles");
        customer.setState("CA");
        customer.setPostalCode("92657");
        customer.setCountry("US");

        customer2 = new Customer();
        customer2.setFirstName("Lebron");
        customer2.setLastName("James");
        customer2.setEmail("LBJ23@gmail.com");
        customer2.setCompany("Los Angeles Lakers");
        customer2.setPhone("2125158902");
        customer2.setAddress1("3333 33rd ave sw");
        customer2.setAddress2("4444 44th ave sw");
        customer2.setCity("Los Angeles");
        customer2.setState("CA");
        customer2.setPostalCode("92657");
        customer2.setCountry("US");

        customer3 = new Customer();
        customer3.setFirstName("Damian");
        customer3.setLastName("James");
        customer3.setEmail("DameTime@gmail.com");
        customer3.setCompany("Portland Trailblazers");
        customer3.setPhone("5034219807");
        customer3.setAddress1("5555 55th ave sw");
        customer3.setAddress2("6666 66th ave sw");
        customer3.setCity("Portland");
        customer3.setState("OR");
        customer3.setPostalCode("92657");
        customer3.setCountry("US");

        customer = customerRepo.save(customer);
        customer2 = customerRepo.save(customer2);
        customer3 = customerRepo.save(customer3);
    }

    @Test
    public void shouldAddCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Smith");

        customer.setEmail("jsmith@netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("123-456-7890");

        customer.setAddress1("1234 Somestreet Drive");
        customer.setAddress2("1212 state street");
        customer.setState("CA");
        customer.setCity("Los Angeles");
        customer.setPostalCode("12345");
        customer.setCountry("US");

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        //System.out.println(customerRepo.findAll());
        assertEquals(customer1.get(), customer);
        assertEquals(4, customerRepo.findAll().size());
    }

    @Test
    public void shouldUpdateCustomer() {
        assertEquals(customerRepo.findById(customer.getCustomerId()).get().getFirstName(), "Kobe");
        customer.setFirstName("Jessie");
        customerRepo.save(customer);
        assertEquals(customerRepo.findById(customer.getCustomerId()).get().getFirstName(), "Jessie");
    }

    @Test
    public void shouldDeleteCustomer() {
        Optional<Customer> customerFromRepo = customerRepo.findById(customer3.getCustomerId());
        assertTrue(customerFromRepo.isPresent());
        customerRepo.deleteById(customer3.getCustomerId());
        Optional<Customer> secondCustomerFromRepo = customerRepo.findById(customer3.getCustomerId());
        assertFalse(secondCustomerFromRepo.isPresent());
    }

    @Test
    public void shouldGetCustomerById() {
        Optional<Customer> customerFromRepo = customerRepo.findById(customer2.getCustomerId());
        assertEquals(customerFromRepo.get(), customer2);
    }
    // Test Finding customer records by state
    @Test
    public void shouldFindAllByState() {
        List<Customer> customerList = customerRepo.findByState("CA");

        // System.out.println(customerList);
        assertEquals(2, customerList.size());
    }
}