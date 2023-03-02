package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    //@MockBean
    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Smith");

        customer.setEmail("jSmith@Netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("323-323-323");

        customer.setAddress1("1234 Somestreet Drive");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    // Test Finding customer records by state
    @Test
    public void findAllByState() {
        Customer customer = new Customer();
        customer.setFirstName("Kobe");
        customer.setLastName("Bryant");
        customer.setEmail("KB24@gmail.com");
        customer.setCompany("Los Angeles Lakers");
        customer.setPhone("2123934567");
        customer.setAddress1("1111 11th ave sw");
        customer.setAddress2("2222 22th ave sw");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("92657");
        customer.setCountry("United States of America");

        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Lebron");
        customer2.setLastName("James");
        customer2.setEmail("LBJ23@gmail.com");
        customer2.setCompany("Los Angeles Lakers");
        customer2.setPhone("2125158902");
        customer2.setAddress1("3333 33rd ave sw");
        customer2.setAddress2("4444 44th ave sw");
        customer2.setCity("Los Angeles");
        customer2.setState("California");
        customer2.setPostalCode("92657");
        customer2.setCountry("United States of America");

        customerRepo.save(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Damian");
        customer3.setLastName("James");
        customer3.setEmail("DameTime@gmail.com");
        customer3.setCompany("Portland Trailblazers");
        customer3.setPhone("5034219807");
        customer3.setAddress1("5555 55th ave sw");
        customer3.setAddress2("6666 66th ave sw");
        customer3.setCity("Portland");
        customer3.setState("Oregon");
        customer3.setPostalCode("92657");
        customer3.setCountry("United States of America");

        customerRepo.save(customer3);

        String state = "California";
        List<Customer> customerList = customerRepo.findByState("California");

        // System.out.println(customerList);
        assertEquals(2, customerList.size());
    }
}