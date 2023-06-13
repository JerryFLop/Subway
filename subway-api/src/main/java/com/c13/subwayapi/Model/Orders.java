package com.c13.subwayapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "type_bread")
       @NotNull
       private String typeOfBread;
        @Column(name = "type_cheese")
        private String typeOfCheese;
        @Column(name = "type_meat")
        private String typeOfMeat;
        @Column(name = "toppings")
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

    public String getTypeOfMeat() {
        return typeOfMeat;
    }

    public void setTypeOfMeat(String typeOfMeat) {
        this.typeOfMeat = typeOfMeat;
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
