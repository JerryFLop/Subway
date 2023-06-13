package com.c13.subwayapi.repo;

import com.c13.subwayapi.Model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends CrudRepository<Orders,Long> {
    Iterable<Orders>findAllOrdersByCustomerId(Long Id);

}
