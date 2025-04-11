package com.alejandro.inventory.repository;

import com.alejandro.inventory.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {}
