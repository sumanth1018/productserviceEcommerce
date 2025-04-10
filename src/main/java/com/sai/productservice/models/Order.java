package com.sai.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
public class Order extends BaseModel{

    @ManyToMany
    @JoinTable(
            name = "product_orders",    // This specify the name of the join table externally
            joinColumns = @JoinColumn(name = "order_id"),   // Column of the this class or this table
            inverseJoinColumns = @JoinColumn(name = "product_id")       // Column of the another class or other table
    )
    private List<Product> product;
}
