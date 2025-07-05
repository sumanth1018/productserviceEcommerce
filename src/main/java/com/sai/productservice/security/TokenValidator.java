package com.sai.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TokenValidator {
    private RestTemplateBuilder restTemplateBuilder;

    public TokenValidator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    /*
    Calls UserService to validate the token
    if token is not valid, returns optinal is empty.
    else optinal contain the all of the data in the payload.
     */
    public Optional<JwtObject> validateToken(String token) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        return Optional.empty();
    }
}
