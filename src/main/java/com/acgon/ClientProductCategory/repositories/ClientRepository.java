package com.acgon.ClientProductCategory.repositories;

import com.acgon.ClientProductCategory.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
