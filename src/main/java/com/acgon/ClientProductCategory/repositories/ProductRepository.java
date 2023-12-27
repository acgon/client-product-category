package com.acgon.ClientProductCategory.repositories;

import com.acgon.ClientProductCategory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
