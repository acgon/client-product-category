package com.acgon.ClientProductCategory.repositories;

import com.acgon.ClientProductCategory.entities.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Long> {

}
