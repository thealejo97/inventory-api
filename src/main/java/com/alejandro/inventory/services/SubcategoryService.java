package com.alejandro.inventory.services;

import com.alejandro.inventory.model.Subcategory;
import com.alejandro.inventory.repository.SubcategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubcategoryService {
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public Subcategory getSubcategoryById(Long id) {
        return subcategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found with id: " + id));
    }

    public Subcategory createSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory updateSubcategory(Long id, Subcategory subcategory) {
        Subcategory existingSubcategory = getSubcategoryById(id);
        existingSubcategory.setName(subcategory.getName());
        existingSubcategory.setDescription(subcategory.getDescription());
        return subcategoryRepository.save(existingSubcategory);
    }

    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}
