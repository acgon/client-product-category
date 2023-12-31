package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Product;
import com.acgon.ClientProductCategory.repositories.DemandRepository;
import com.acgon.ClientProductCategory.repositories.ProductRepository;
import com.acgon.ClientProductCategory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Product insert(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        Long id = product.getId();
        Product _product = repository.findById(id).get();
        _product.setName(product.getName());
        _product.setPrice(product.getPrice());
        _product.setDemand(product.getDemand());
        return repository.save(_product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/demand/{product_id}")
    public Product addDemand(@PathVariable Long product_id, @RequestParam(name = "demand_id") Long demand_id) {
        return service.addDemand(product_id, demand_id);
    }

    @DeleteMapping(value = "/demand/{id}")
    public Product removeDemand(@PathVariable Long id) {
        return service.removeDemand(id);
    }

    @PutMapping(value = "/category/{product_id}")
    public Product addCategory(@PathVariable Long product_id, @RequestParam(name = "category_id") Long category_id) {
        return service.addCategory(product_id, category_id);
    }

    @DeleteMapping(value = "/category/{product_id}")
    public Product removeCategory(@PathVariable Long product_id, @RequestParam(name = "category_id") Long category_id) {
        return service.removeCategory(product_id, category_id);
    }

}
