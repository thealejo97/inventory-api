package com.alejandro.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@Table(name = "products")
@Schema(description = "Entity that represents a product in the inventory")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique product ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Product name", example = "Dell XPS Laptop", required = true)
    private String name;
    
    @Schema(description = "Detailed product description", example = "High-end laptop with i7 processor")
    private String description;
    
    @Column(nullable = false)
    @Schema(description = "Unit price of the product", example = "1299.99", required = true)
    private BigDecimal price;
    
    @Column(nullable = false)
    @Schema(description = "Available quantity in inventory", example = "10", required = true)
    private Integer stock;
    
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;

    public Product() {
    }
    
    public Product(String name, String description, BigDecimal price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}