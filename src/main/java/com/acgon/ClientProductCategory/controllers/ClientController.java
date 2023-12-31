package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Client;
import com.acgon.ClientProductCategory.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

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
}
