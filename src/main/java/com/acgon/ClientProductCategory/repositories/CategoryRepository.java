package com.acgon.ClientProductCategory.repositories;

import com.acgon.ClientProductCategory.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
