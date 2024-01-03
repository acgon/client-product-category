package com.acgon.ClientProductCategory.services;

import com.acgon.ClientProductCategory.entities.Category;
import com.acgon.ClientProductCategory.entities.Product;
import com.acgon.ClientProductCategory.repositories.CategoryRepository;
import com.acgon.ClientProductCategory.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public CategoryService() {}

    @Transactional
    public Category addProduct(Long product_id, Long category_id) {
        Product product = productRepository.findById(product_id).get();
        Category category = categoryRepository.findById(category_id).get();
        category.addProduct(product);
        return categoryRepository.save(category);
    }

    @Transactional
    public Category removeProduct(Long product_id, Long category_id) {
        Product product = productRepository.findById(product_id).get();
        Category category = categoryRepository.findById(category_id).get();
        category.removeProduct(product);
        return categoryRepository.save(category);
    }
}
