package com.acgon.ClientProductCategory.controllers;

import com.acgon.ClientProductCategory.entities.Client;
import com.acgon.ClientProductCategory.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client find() {
        return null;
    }
}
