package com.c13.subwayapi.services;

import com.c13.subwayapi.Model.Customer;
import com.c13.subwayapi.Model.Orders;
import com.c13.subwayapi.repo.CustomerRepo;
import com.c13.subwayapi.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class OrderService {
@Autowired
    private OrdersRepo ordersRepo;

@Autowired
private CustomerRepo customerRepo;


public void addOrder(Long customerId , Orders orders){
    Customer customer = customerRepo.findById(customerId).orElse(null);

    orders.setCustomer(customer);

    ordersRepo.save( orders);
}

public List<Orders> getAllOrdersByCustomerId(Long customerId){
     return ordersRepo.findAllOrdersByCustomerId(customerId);
}


public void updateOrder(Long customerId,Long ordersId, Orders orders) {

    Customer customer = customerRepo.findById(customerId).orElse(null);
    Orders o = ordersRepo.findById(ordersId).orElse(null);
    if (o != null) {

        o.setTypeOfBread(orders.getTypeOfBread());
        o.setTypeOfCheese(orders.getTypeOfCheese());
        o.setToppings(orders.getToppings());
    }
    orders.setCustomer(customer);
    ordersRepo.save(orders);

}
public void deleteOrder(Long ordersId){
    ordersRepo.deleteById(ordersId);
    }





}












