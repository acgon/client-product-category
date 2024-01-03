package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Demand;
import com.acgon.ClientProductCategory.repositories.DemandRepository;
import com.acgon.ClientProductCategory.services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/demand")
public class DemandController {

    @Autowired
    DemandRepository repository;

    @Autowired
    DemandService service;

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

    @PutMapping(value = "/client/{client_id}")
    public Demand addClient(@PathVariable Long client_id, @RequestParam(name = "demand_id") Long demand_id) {
        return service.addClient(client_id, demand_id);
    }

    @DeleteMapping(value = "/client/{id}")
    public Demand removeClient(@PathVariable Long id) {
        return service.removeClient(id);
    }

    @PutMapping(value = "/product/{demand_id}")
    public Demand addProduct(@PathVariable Long demand_id, @RequestParam(name = "product_id") Long product_id) {
        return service.addProduct(product_id, demand_id);
    }

    @DeleteMapping(value = "product/{demand_id}")
    public Demand removeProduct(@PathVariable Long demand_id, @RequestParam(name = "product_id") Long product_id) {
        return service.removeProduct(product_id, demand_id);
    }
}
