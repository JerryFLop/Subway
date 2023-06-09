package com.c13.subwayapi.services;

import com.c13.subwayapi.Model.Customer;
import com.c13.subwayapi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
@Autowired
    private CustomerRepo customerRepo;


    public void addCustomer(Customer customer){
        customerRepo.save(customer);
    }

  public Customer getCustomerId(Long id){
       return customerRepo.findById( id).orElse(null);

}

public void updateCustomer(Long id, Customer customer){
customer.setId(id);
customerRepo.save(customer);


}

    public Iterable<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public void deleteCustomer(Long id){
        customerRepo.deleteById(id);
    }


    public Customer findACustomerByName(String name){
        return customerRepo.findByName(name);
    }

}
