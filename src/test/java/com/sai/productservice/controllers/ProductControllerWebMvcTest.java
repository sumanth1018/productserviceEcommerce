package com.sai.productservice.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


@WebMvcTest(ProductController.class)
// It will only initialize the contollers, services, repositories that are going to link to the apis, it doesn't initialize any unnecessary bean.
// It only initializedepandencies thet can be reached from product controller

public class ProductControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(("[]")));
    }

    @Test
    void returnsListOfProductWhenProductsExists() throws Exception {
        ArrayList<GenericProductDto> products = new ArrayList<>();
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());

        when(
                productService.getAllProducts()
        ).thenReturn(products);

        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(products))
                );
    }

    @Test
        void createProdutShouldCreateNewProduct() throws Exception {
        GenericProductDto productToCreate = new GenericProductDto();
        productToCreate.setId(10l);
        productToCreate.setTitle("iphone");
        productToCreate.setImage("some image");
        productToCreate.setCategory("mobile phones");
        productToCreate.setDescription("some description");

        GenericProductDto expectedProduct = new GenericProductDto();
        expectedProduct.setId(1001l);
        expectedProduct.setTitle("iphone");
        expectedProduct.setImage("some image");
        expectedProduct.setCategory("mobile phones");
        expectedProduct.setDescription("some description");

        when(productService.createProduct(any())).thenReturn(expectedProduct);

        mockMvc.perform(
                    post("/api/v1/products")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(productToCreate))
            ).andExpect(
                    content().string(objectMapper.writeValueAsString(expectedProduct))
        ).andExpect(status().is(200));
              //  .andExpect((ResultMatcher) jsonPath("$", matches("1001")));
    }
}
