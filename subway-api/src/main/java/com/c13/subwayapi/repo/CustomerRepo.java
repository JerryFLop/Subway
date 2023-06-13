package com.c13.subwayapi.repo;

import com.c13.subwayapi.Model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer,Long>{
 List<Customer> findByName(String name);
}
