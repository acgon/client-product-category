package com.acgon.ClientProductCategory.services;

import com.acgon.ClientProductCategory.entities.Category;
import com.acgon.ClientProductCategory.entities.Demand;
import com.acgon.ClientProductCategory.entities.Product;
import com.acgon.ClientProductCategory.repositories.CategoryRepository;
import com.acgon.ClientProductCategory.repositories.DemandRepository;
import com.acgon.ClientProductCategory.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DemandRepository demandRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, DemandRepository demandRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.demandRepository = demandRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductService() {}

    @Transactional
    public Product addDemand(Long product_id, Long demand_id) {
        Product product = productRepository.findById(product_id).get();
        Demand demand = demandRepository.findById(demand_id).get();
        product.setDemand(demand);
        return productRepository.save(product);
    }

    @Transactional
    public Product removeDemand(Long id) {
        Product product = productRepository.findById(id).get();
        product.setDemand(null);
        return productRepository.save(product);
    }

    @Transactional
    public Product addCategory(Long product_id, Long category_id) {
        Product product = productRepository.findById(product_id).get();
        Category category = categoryRepository.findById(category_id).get();
        product.addCategory(category);
        return productRepository.save(product);
    }

    @Transactional
    public Product removeCategory(Long product_id, Long category_id) {
        Product product = productRepository.findById(product_id).get();
        Category category = categoryRepository.findById(category_id).get();
        product.removeCategory(category);
        return productRepository.save(product);
    }

}
