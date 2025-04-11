package com.alejandro.inventory.controller;

import com.alejandro.inventory.model.Sale;
import com.alejandro.inventory.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/sales")
@Tag(name = "Sales", description = "API for managing sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    @Operation(summary = "Get all sales", description = "Returns a list of all recorded sales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }
    
    @GetMapping("/{id}")
    @Operation(
        summary = "Get a sale by ID", 
        description = "Returns a single sale based on its ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Sale found"),
            @ApiResponse(responseCode = "404", description = "Sale not found", content = @Content)
        }
    )
    public ResponseEntity<Sale> getSaleById(
            @Parameter(description = "ID of the sale to search", required = true)
            @PathVariable Long id) {
        Sale sale = saleService.getSaleById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found with ID: " + id));
        return ResponseEntity.ok(sale);
    }

    @PostMapping
    @Operation(
        summary = "Create a new sale", 
        description = "Creates a new sale record",
        responses = {
            @ApiResponse(responseCode = "201", description = "Sale successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid sale data", content = @Content)
        }
    )
    public ResponseEntity<Sale> createSale(
            @Parameter(description = "Sale data to create", required = true, schema = @Schema(implementation = Sale.class))
            @RequestBody Sale sale) {
        Sale createdSale = saleService.createSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSale);
    }
    
    @PutMapping("/{id}")
    @Operation(
        summary = "Update an existing sale", 
        description = "Updates an existing sale based on its ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Sale successfully updated"),
            @ApiResponse(responseCode = "404", description = "Sale not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid sale data", content = @Content)
        }
    )
    public ResponseEntity<Sale> updateSale(
            @Parameter(description = "ID of the sale to update", required = true)
            @PathVariable Long id, 
            @Parameter(description = "Updated sale data", required = true)
            @RequestBody Sale sale) {
        Sale updatedSale = saleService.updateSale(id, sale);
        return ResponseEntity.ok(updatedSale);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete a sale", 
        description = "Deletes an existing sale based on its ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Sale successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Sale not found", content = @Content)
        }
    )
    public ResponseEntity<Void> deleteSale(
            @Parameter(description = "ID of the sale to delete", required = true)
            @PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
