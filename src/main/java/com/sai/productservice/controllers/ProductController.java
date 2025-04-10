package com.sai.productservice.controllers;

import com.sai.productservice.dtos.ExceptionDto;
import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.exceptions.NotFoundException;
import com.sai.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/products")  // If any thing is repeating then add here, it is going to add this to all its api calls
public class ProductController {

    // @Autowired    // Called Field Injection (Not Recommended)
    private ProductService productService;          // Dependency Injection

    //Constructor Injection  (It is best practice)
    public  ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;       // @Qualifier("selfProductServiceImpl") - Uses if multiple classes are of same type (productService) Then spring will confuse the which class should be intialized, give the names to the classes and call via name here
    }

    //@Autowired  // Injection via setter (Not Recommended)
    //public void setProductService(ProductService productService){
    //    this.productService = productService;
    //}

    @GetMapping
    public ResponseEntity<List<GenericProductDto>> getAllProducts(){
        List<GenericProductDto> productDtos = productService.getProducts();
        if (productDtos.isEmpty()){
            return new ResponseEntity<>(productDtos,
                    HttpStatus.NOT_FOUND);
        }

//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        for (GenericProductDto gpd : productDtos){
//            genericProductDtos.add(gpd);
//        }

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }



    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id) throws NotFoundException{    // @PathVariable("id") = ensures that argument variabel and the path variable (id in the path) is same
        GenericProductDto productDto = productService.getProductById(id);
        if (productDto == null){
            // throw NotFoundException
        }
        return productDto;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        //System.out.println(product);
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductById(){}
}
