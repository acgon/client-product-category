package com.acgon.ClientProductCategory.services;

import com.acgon.ClientProductCategory.entities.Client;
import com.acgon.ClientProductCategory.entities.Demand;
import com.acgon.ClientProductCategory.entities.Product;
import com.acgon.ClientProductCategory.repositories.ClientRepository;
import com.acgon.ClientProductCategory.repositories.DemandRepository;
import com.acgon.ClientProductCategory.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    public DemandService(DemandRepository demandRepository, ClientRepository clientRepository) {
        this.demandRepository = demandRepository;
        this.clientRepository = clientRepository;
    }

    public DemandService() {}

    @Transactional
    public Demand addClient(Long client_id, Long demand_id) {
        Client client = clientRepository.findById(client_id).get();
        Demand demand = demandRepository.findById(demand_id).get();
        demand.setClient(client);
        return demandRepository.save(demand);
    }

    @Transactional
    public Demand removeClient(Long id) {
        Demand demand = demandRepository.findById(id).get();
        demand.setClient(null);
        return demandRepository.save(demand);
    }

    @Transactional
    public Demand addProduct(Long product_id, Long demand_id) {
        Product product = productRepository.findById(product_id).get();
        Demand demand = demandRepository.findById(demand_id).get();
        demand.addProduct(product);
        return demandRepository.save(demand);
    }

    @Transactional
    public Demand removeProduct(Long product_id, Long demand_id) {
        Product product = productRepository.findById(product_id).get();
        Demand demand = demandRepository.findById(demand_id).get();
        demand.removeProduct(product);
        return demandRepository.save(demand);
    }
}
