package com.alejandro.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Entity that represents a sale in the system")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique sale ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Date and time of the sale", example = "2025-04-11T15:30:45", required = true)
    private LocalDateTime date;
    
    @Schema(description = "Total amount of the sale", example = "299.99", required = true)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Schema(description = "Product associated with this sale", required = true)
    private Product product;
    
    // Constructor vacío requerido por JPA
    public Sale() {
    }
    
    // Constructor para facilitar la creación
    public Sale(LocalDateTime date, double amount, Product product) {
        this.date = date;
        this.amount = amount;
        this.product = product;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }   

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
