package com.c13.subwayapi.services;

import com.c13.subwayapi.Model.Customer;
import com.c13.subwayapi.Model.Orders;
import com.c13.subwayapi.eceptions.ResourceNotFoundException;
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


protected void verifyOrdersExists(Long idOfOrder)throws ResourceNotFoundException {
    if(!(ordersRepo.existsById(idOfOrder))){
        throw new ResourceNotFoundException("Order with id of" + idOfOrder + "does not exists");
    }
}

public void addOrder(Long customerId , Orders orders){

    Customer customer = customerRepo.findById(customerId).orElse(null);
    orders.setCustomer(customer);
    ordersRepo.save( orders);
}

public Iterable<Orders> getAllOrdersByCustomerId(Long customerId){
     return ordersRepo.findAllOrdersByCustomerId(customerId);
}


public void updateOrder(Long customerId,Long ordersId, Orders orders) {
this.verifyOrdersExists(ordersId);
    Customer customer = customerRepo.findById(customerId).orElse(null);
    Orders o = ordersRepo.findById(ordersId).orElse(null);
    if (o != null) {

        o.setTypeOfBread(orders.getTypeOfBread());
        o.setTypeOfCheese(orders.getTypeOfCheese());
        o.setTypeOfMeat(orders.getTypeOfMeat());
        o.setToppings(orders.getToppings());
    }
    orders.setCustomer(customer);
    ordersRepo.save(orders);

}
public void deleteOrder(Long ordersId){
    this.verifyOrdersExists(ordersId);
    ordersRepo.deleteById(ordersId);
    }

public Orders getOrderById(Long id){
    this.verifyOrdersExists(id);
    return ordersRepo.findById(id).orElse(null);
}



}












