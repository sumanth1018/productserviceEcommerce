package com.sai.productservice.services;

import com.sai.productservice.models.Category;
import com.sai.productservice.models.Product;
import com.sai.productservice.repositories.CategoryRepository;
import com.sai.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CategoryServiceImpl implements CategoryService{
    private final ProductRepository productRepository;
    private CategoryRepository categoryRepository;

   public  CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository){
       this.categoryRepository=categoryRepository;
       this.productRepository = productRepository;
   }



    @Override
    public Category getCategory(String uuid) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();
        List<Product> products = category.getProducts();
       return category;
    }

    public List<String> getProductTitles( List<String> categoryUUIDs) {     // For Multiple categories
        List<UUID> uuids = new ArrayList<>();

        for (String categoryUUID : categoryUUIDs) {
            uuids.add(UUID.fromString(categoryUUID));
        }

        List<Category> categories = categoryRepository.findAllById(uuids);
        List<Product> products = productRepository.findAllByCategoryIn(categories);

        List<String> titles = new ArrayList<>();
        for (Product product : products) {
            titles.add(product.getTitle());
        }
        return titles;

       /*       Good. Better version exist
       List<UUID> uuids = new ArrayList<>();

       for (String categoryUUID : categoryUUIDs) {
           uuids.add(UUID.fromString(categoryUUID));
       }

       List<Category> categories = categoryRepository.findAllById(uuids);

        List<String> titles = new ArrayList<>();

        categories.forEach( category -> {
            category.getProducts().forEach(product -> {
                titles.add(product.getTitle());
            });
        });

        return titles;

        */

       /*  For One Category
       Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();

        List<String> titles = new ArrayList<>();

        category.getProducts().forEach(
                product -> titles.add(product.getTitle())
        );
        return titles;

        */
    }



    /*
    @Override
    public String getCategory(UUID uuid) {
        return categoryRepository.findById(uuid)
                .map(Category::getName)  // Extracts category name
                .orElse(null);  // Returns null if category is not found
    }

     */


}
