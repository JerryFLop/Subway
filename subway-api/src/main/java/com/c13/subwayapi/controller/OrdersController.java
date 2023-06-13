package com.c13.subwayapi.controller;

import com.c13.subwayapi.Model.Orders;
import com.c13.subwayapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    private OrderService ordersService;

    @PostMapping("/customers/{customerId}/orders")
    public ResponseEntity<Void> createOrder(@PathVariable Long customerId, @RequestBody Orders order){
        ordersService.addOrder(customerId, order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //Get all orders by customer id
    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<Iterable<Orders>> getAllOrdersByCustomerId(@PathVariable Long customerId){
        return new ResponseEntity<>(ordersService.getAllOrdersByCustomerId(customerId), HttpStatus.OK);

    }

    //update an order
    @PutMapping("/customers/{customerId}/orders/{orderId}")
    public ResponseEntity<Void> updateOrder(@PathVariable Long customerId, @PathVariable Long orderId, @RequestBody Orders order ){
        ordersService.updateOrder(customerId, orderId, order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //get an order by ID
    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id){
        return new ResponseEntity<>(ordersService.getOrderById(id), HttpStatus.OK);
    }


    //delete an order

@DeleteMapping("/orders/{id}")
public ResponseEntity<Void> removeOrder(@PathVariable Long id){
        ordersService.deleteOrder(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
