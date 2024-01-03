package com.acgon.ClientProductCategory.services;

import com.acgon.ClientProductCategory.entities.Client;
import com.acgon.ClientProductCategory.entities.Demand;
import com.acgon.ClientProductCategory.repositories.ClientRepository;
import com.acgon.ClientProductCategory.repositories.DemandRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DemandRepository demandRepository;

    public ClientService(ClientRepository clientRepository, DemandRepository demandRepository) {
        this.clientRepository = clientRepository;
        this.demandRepository = demandRepository;
    }

    public ClientService() {}

    @Transactional
    public Client addDemand(Long client_id, Long demand_id) {
        Client client = clientRepository.findById(client_id).get();
        Demand demand = demandRepository.findById(demand_id).get();
        client.setDemand(demand);
        return clientRepository.save(client);
    }

    @Transactional
    public Client removeDemand(Long id) {
        Client client = clientRepository.findById(id).get();
        client.setDemand(null);
        return clientRepository.save(client);
    }
}
