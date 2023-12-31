package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Demand;
import com.acgon.ClientProductCategory.repositories.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/demand")
public class DemandController {

    @Autowired
    DemandRepository repository;

    @GetMapping
    public List<Demand> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Demand findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Demand insert(@RequestBody Demand demand) {
        return repository.save(demand);
    }

    @PutMapping
    public Demand update(@RequestBody Demand demand) {
        Long id = demand.getId();
        Demand _demand = repository.findById(id).get();
        return repository.save(_demand);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
