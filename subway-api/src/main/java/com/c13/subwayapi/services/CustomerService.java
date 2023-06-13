package com.c13.subwayapi.services;

import com.c13.subwayapi.Model.Customer;
import com.c13.subwayapi.eceptions.ResourceNotFoundException;
import com.c13.subwayapi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
@Autowired
    private CustomerRepo customerRepo;




protected void verifyCustomerId(Long customerId) throws ResourceNotFoundException{
    if(!(this.customerRepo.existsById(customerId))){
        throw new ResourceNotFoundException("Customer with Id Of" + customerId + "does not exist" );
    }
}

    public void addCustomer(Customer customer){
        customerRepo.save(customer);
    }

  public Customer getCustomerId(Long idOfCustomer){
    this.verifyCustomerId(idOfCustomer);
       return customerRepo.findById(idOfCustomer).orElse(null);

}

  public void updateCustomer(Long idOfCustomer, Customer updatecustomer) throws ResourceNotFoundException{
 this.verifyCustomerId(idOfCustomer);
 Customer customer = customerRepo.findById(idOfCustomer).get();
 customer.setName(updatecustomer.getName());
 customerRepo.save(updatecustomer);
}

    public Iterable<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public void deleteCustomer(Long id){
   this.verifyCustomerId(id);
        customerRepo.deleteById(id);

    }


    public Customer findACustomerByName(String name){
        return customerRepo.findByName(name);
    }

}
