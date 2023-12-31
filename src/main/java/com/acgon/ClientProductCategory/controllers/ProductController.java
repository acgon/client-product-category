package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Product;
import com.acgon.ClientProductCategory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

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
        return repository.save(_product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
