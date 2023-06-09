package com.c13.subwayapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
public class Orders {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeOfBread;
    private String typeOfCheese;

    private String[] Toppings ;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "customer_id", nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIgnore
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(String typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    public String getTypeOfCheese() {
        return typeOfCheese;
    }

    public void setTypeOfCheese(String typeOfCheese) {
        this.typeOfCheese = typeOfCheese;
    }

    public String[] getToppings() {
        return Toppings;
    }

    public void setToppings(String[] toppings) {
        Toppings = toppings;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
