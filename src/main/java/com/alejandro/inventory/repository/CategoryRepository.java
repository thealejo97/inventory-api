package com.alejandro.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alejandro.inventory.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}

