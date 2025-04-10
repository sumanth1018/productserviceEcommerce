package com.sai.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "categories")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor


public class Category extends BaseModel{

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    @Fetch(FetchMode.SUBSELECT)     // SUBSELECT Will solve the (n+1) db calls problem. It will get results in 2 calls, The default mode is SELECT. SUBSELECT only works when it is a multi valued attribute
    // FetchMode.JOIN -
    // Tells that is the same relation being mapped by category attribute in the other(Product) class
    private List<Product> products =  new ArrayList<>();

}
