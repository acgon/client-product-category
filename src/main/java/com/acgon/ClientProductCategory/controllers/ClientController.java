package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Client;
import com.acgon.ClientProductCategory.repositories.ClientRepository;
import com.acgon.ClientProductCategory.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Client findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Client insert(@RequestBody Client client) {
        return repository.save(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        Long id = client.getId();
        Client _client = repository.findById(id).get();
        _client.setName(client.getName());
        return repository.save(_client);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/demand/{client_id}")
    public Client addDemand(@PathVariable Long client_id, @RequestParam(name = "demand_id") Long demand_id) {
        return service.addDemand(client_id, demand_id);
    }

    @DeleteMapping(value = "/demand/{id}")
    public Client removeDemand(@PathVariable Long id) {
        return service.removeDemand(id);
    }
}
