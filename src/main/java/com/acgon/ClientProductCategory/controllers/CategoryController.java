package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Category;
import com.acgon.ClientProductCategory.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

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
}
