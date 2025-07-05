package com.sai.productservice.security;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sai.productservice.models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Role extends BaseModel {
    private Long id;
    private String role;
}
