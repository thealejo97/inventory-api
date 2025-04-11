package com.alejandro.inventory.repository;

import com.alejandro.inventory.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
