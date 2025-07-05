package com.sai.productservice.dtos;

import com.sai.productservice.security.JwtObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Request<T> {
    T userPayload;
    JwtObject authPayload;
}
