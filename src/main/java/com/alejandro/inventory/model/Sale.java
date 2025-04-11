package com.alejandro.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name = "sales")
@Schema(description = "Entity that represents a sale in the system")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique sale ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Date and time of the sale", example = "2025-04-11T15:30:45", required = true)
    private LocalDateTime saleDate;
    
    @Column(nullable = false)
    @Schema(description = "Total amount of the sale", example = "299.99", required = true)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @Schema(description = "Items associated with this sale")
    private List<SaleItem> items;
    
    
    public Sale() {
    }
    
    
    public Sale(LocalDateTime date, double amount, Product product) {
        this.saleDate = date;
        this.totalAmount = BigDecimal.valueOf(amount);
        this.product = product;
    }
    
}
