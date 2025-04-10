package com.sai.productservice.repositories;

import com.sai.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Override
    Optional<Category> findById(UUID id);

    @Override
    List<Category> findAllById(Iterable<UUID> uuids);
}
