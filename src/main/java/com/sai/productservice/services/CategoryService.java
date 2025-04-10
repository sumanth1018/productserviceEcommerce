package com.sai.productservice.services;

import com.sai.productservice.models.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    Category getCategory(String uuid);

    //List<String> getProductTitles(String uuid);

    List<String> getProductTitles( List<String> categoryUUIDs);
}
