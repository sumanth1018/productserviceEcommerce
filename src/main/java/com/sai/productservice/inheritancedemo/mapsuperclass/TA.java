package com.sai.productservice.inheritancedemo.mapsuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_ta")
public class TA extends User{
    private double averageRating;
}
