package com.company.customerdataservice.controller;

import com.company.customerdataservice.controller.CustomerController;
import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerController repo;

    private ObjectMapper mapper = new ObjectMapper();
    private List<Customer> customerList;




    @Before
    public void setUp() throws Exception {
    }

    // Test Post that creates a new Customer
    @Test
    public void shouldReturnNewCustomerOnPost() throws Exception {
        // Arrange
        Customer inputCustomer = new Customer();
        inputCustomer.setFirstName("Kobe");
        inputCustomer.setLastName("Bryant");
        inputCustomer.setEmail("KB24@gmail.com");
        inputCustomer.setCompany("LA Lakers");
        inputCustomer.setPhone("1234567890");
        inputCustomer.setAddress1("12th st");
        inputCustomer.setAddress2("13th st");
        inputCustomer.setCity("Los Angeles");
        inputCustomer.setState("California");
        inputCustomer.setPostalCode("90210");
        inputCustomer.setCountry("USA");

        String inputJson = mapper.writeValueAsString(inputCustomer);



        mockMvc.perform(
                post("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated());
    }


    // Test Put route that updates an existing customer
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        Customer inputCustomer = new Customer();
        inputCustomer.setFirstName("Kobe");
        inputCustomer.setLastName("Bryant");
        inputCustomer.setEmail("KB24@gmail.com");
        inputCustomer.setCompany("LA Lakers");
        inputCustomer.setPhone("1234567890");
        inputCustomer.setAddress1("12th st");
        inputCustomer.setAddress2("13th st");
        inputCustomer.setCity("Los Angeles");
        inputCustomer.setState("California");
        inputCustomer.setPostalCode("90210");
        inputCustomer.setCountry("USA");
        inputCustomer.setCustomerId(24);

        String inputJson = mapper.writeValueAsString(inputCustomer);

        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Test Delete route that deletes an existing customer
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/customers/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Tests Get route that returns a specific customer by id
    @Test
    public void shouldReturnSpecificCustomerById () throws Exception {
        // Arrange
        Customer outputCustomer = new Customer();
        outputCustomer.setFirstName("Kobe");
        outputCustomer.setLastName("Bryant");
        outputCustomer.setEmail("KB24@gmail.com");
        outputCustomer.setCompany("LA Lakers");
        outputCustomer.setPhone("1234567890");
        outputCustomer.setAddress1("12th st");
        outputCustomer.setAddress2("13th st");
        outputCustomer.setCity("Los Angeles");
        outputCustomer.setState("California");
        outputCustomer.setPostalCode("90210");
        outputCustomer.setCountry("USA");
        outputCustomer.setCustomerId(24);

        String outputJson = mapper.writeValueAsString(outputCustomer);
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/24")).andDo(print()).andExpect(status().isAccepted());
    }

    // Tests Get route that returns all customers for a specific state
    @Test
    public void shouldHaveTwoCaliPeople() throws Exception{
        Customer outputCustomer = new Customer();
        outputCustomer.setFirstName("Kobe");
        outputCustomer.setLastName("Bryant");
        outputCustomer.setEmail("KB24@gmail.com");
        outputCustomer.setCompany("LA Lakers");
        outputCustomer.setPhone("1234567890");
        outputCustomer.setAddress1("12th st");
        outputCustomer.setAddress2("13th st");
        outputCustomer.setCity("Los Angeles");
        outputCustomer.setState("California");
        outputCustomer.setPostalCode("90210");
        outputCustomer.setCountry("USA");
        outputCustomer.setCustomerId(24);
        String outputJson = mapper.writeValueAsString(outputCustomer);
//        mockMvc.perform(get("/customers/state/California"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(content().json(outputJson));

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/state/California")).andDo(print()).andExpect(status().isAccepted());
    }
}