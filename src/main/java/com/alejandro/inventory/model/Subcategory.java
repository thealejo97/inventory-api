package com.alejandro.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@Table(name = "subcategories")
@Schema(description = "Entity that represents a product subcategory")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique subcategory ID", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Subcategory name", example = "Laptops", required = true)
    private String name;

    @Schema(description = "Subcategory description", example = "Portable computers")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @Schema(description = "Parent category", required = true)
    private Category category;

    // Constructors
    public Subcategory() {
    }

    public Subcategory(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // Getters and Setters
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}