package com.acgon.ClientProductCategory.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Entity
@Table(name = "Category")
public class Category {
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(Long id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Category() {}

    @ManyToMany(mappedBy = "categories")
    @Autowired
    private Set<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
