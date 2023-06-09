package com.c13.subwayapi.repo;

import com.c13.subwayapi.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long>{
 Customer findByName(String name);
}
