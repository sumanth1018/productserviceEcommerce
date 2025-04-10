package com.sai.productservice.repositories;

import com.sai.productservice.models.Category;
import com.sai.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByTitleEquals(String title);

    Product findByTitleEqualsAndPrice_Price(String title, double price);

    List<Product> findAllByPrice_Currency(String currency);


    List<Product> findAllByCategoryIn(List<Category> categories);

    /*
    @Query("select Product from Product where Product .category.uuid in :uuids")
    List<Product> findAllByCategoryIn(List<UUID> uuids);
    */
}

