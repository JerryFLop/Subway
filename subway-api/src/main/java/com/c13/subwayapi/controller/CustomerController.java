package com.c13.subwayapi.controller;

import com.c13.subwayapi.Model.Customer;
import com.c13.subwayapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //endpoint to create a customer
    @PostMapping("/customers")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/customers/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // get a customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer>getCustomerById(@PathVariable Long id){

         return new ResponseEntity<>( customerService.getCustomerId(id),HttpStatus.OK);
    }

    //delete by id
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customers")
    public ResponseEntity<?>getCustomerByName(@RequestParam(value = "name", required = false) String name){

        Customer customer = customerService.findACustomerByName(name);

        if(name != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }

        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);



    }


}
