package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Category;
import com.acgon.ClientProductCategory.entities.Product;
import com.acgon.ClientProductCategory.repositories.CategoryRepository;
import com.acgon.ClientProductCategory.services.CategoryService;
import com.acgon.ClientProductCategory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Category> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Category insert(@RequestBody Category category) {
        return repository.save(category);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        Long id = category.getId();
        Category _category = repository.findById(id).get();
        _category.setName(category.getName());
        return repository.save(_category);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/product/{category_id}")
    public void addProduct(@PathVariable Long category_id, @RequestParam(name = "product_id") Long product_id) {
        productService.addCategory(product_id, category_id);
    }

    @DeleteMapping(value = "/product/{category_id}")
    public void removeProduct(@PathVariable Long category_id, @RequestParam(name = "product_id") Long product_id) {
        productService.removeCategory(product_id, category_id);
    }
}
