package com.c13.subwayapi.controller;

import com.c13.subwayapi.Model.Customer;
import com.c13.subwayapi.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

   public static Logger logger = LoggerFactory.getLogger(CustomerController.class);
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
    private ResponseEntity<Iterable<Customer>>getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
}


    @GetMapping("/customers/search")
    public ResponseEntity<List<Customer>>getCustomerByName(@RequestParam(value = "name", required = false) String name){


        return new ResponseEntity<>(customerService.findACustomerByName(name), HttpStatus.OK);



    }


}
