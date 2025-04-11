package com.alejandro.inventory.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Entity that represents a product in the inventory")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique product ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Product name", example = "Dell XPS Laptop", required = true)
    private String name;
    
    @Schema(description = "Detailed product description", example = "High-end laptop with i7 processor")
    private String description;
    
    @Schema(description = "Unit price of the product", example = "1299.99", required = true)
    private double price;
    
    
    @Schema(description = "Available quantity in inventory", example = "10", required = true)
    private int stock;
    
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

    
    public Product() {
    }
    
    
    public Product(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Sale> getSales() {
        return sales;
    }
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}