package com.acgon.ClientProductCategory.repositories;

import com.acgon.ClientProductCategory.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
