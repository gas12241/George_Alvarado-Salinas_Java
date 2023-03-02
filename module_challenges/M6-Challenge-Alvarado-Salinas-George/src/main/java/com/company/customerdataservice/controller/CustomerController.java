package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This is the Controller for my Customer. Has the Mappings for
 * the Requests you can make.
 */
@RestController
public class CustomerController {

    /**
     * The repo I will be using for the request calls.
     */
    @Autowired
    CustomerRepository repo;

    /**
     * Post Mapping that will create a new customer with a
     * given inputted customer.
     * @param customer Customer being inputted, shouldn't
     *                 have the Id, as it is made in the DB itself.
     * @return Should return the item that was just created.
     */
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    /**
     * Puts (Updates) a current customer when given a customer WITH an ID.
     * @param customer Customer that will be updated, should also include
     *                 the ID to know what Customer is going to be updated.
     */
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    /**
     * Deletes a customer by Id.
     * @param id the id given that will let the program know what Customer
     *           to delete.
     */
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }


    /**
     * Gets a customer by their ID.
     * @param id id that will be used to get a Customer back
     *           from the DB.
     * @return Returns the customer that you were looking for
     *         by its id.
     */
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    /**
     * Gets a list of Customers depending on the state they
     * are from.
     * @param state state that you are getting customers for.
     * @return Returns a List of Customers depending on the
     *         state they live in.
     */
    @GetMapping("/customers/state/{state}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return repo.findByState(state);
    }
}
