package com.sai.productservice.controllers;


import com.sai.productservice.dtos.GetProductTitlesRequestDto;
import com.sai.productservice.dtos.ProductDto;
import com.sai.productservice.models.Category;
import com.sai.productservice.models.Product;
import com.sai.productservice.services.CategoryService;
import com.sai.productservice.services.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @GetMapping("/{uuid}")
    public List<ProductDto> getCategory(@PathVariable("uuid") String uuid) {

        List<Product> products = categoryService.getCategory(uuid).getProducts();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setDescription(product.getDescription());
            productDto.setImage(product.getImage());
            productDto.setTitle(product.getTitle());
            productDto.setPrice(product.getPrice());
            productDtos.add(productDto);
        }

        return productDtos;
    }

    /*
    @GetMapping("/titles/{uuid}")
    public List<String> getProductTitles(@PathVariable("uuid") String uuid) {
        return categoryService.getProductTitles(uuid);
    }

     */

    @GetMapping("/titles")
    public List<String> getProductTitles(@RequestBody GetProductTitlesRequestDto requestDto) {
        List<String> uuids = requestDto.getUuids();

        return categoryService.getProductTitles(uuids);
    }




 /*
@GetMapping("/{uuid}")
public ResponseEntity<String> getCategory(@PathVariable("uuid") String uuid) {
    try {
        UUID categoryId = UUID.fromString(uuid);  // ✅ Convert String to UUID
        String categoryName = categoryService.getCategory(categoryId);

        if (categoryName == null) {
            return ResponseEntity.notFound().build(); // ✅ If not found, return 404
        }

        return ResponseEntity.ok(categoryName); // ✅ Return category name
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().build(); // ✅ Handle invalid UUID format
    }
}

  */


}
