package com.acgon.ClientProductCategory.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Demand getOrder() {
        return demand;
    }

    public void setOrder(Demand demand) {
        this.demand = demand;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Product(Long id, String name, double price, Demand demand) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {}

    private double price;

    @ManyToOne
    @JoinColumn(name = "demand_id")
    private Demand demand;

    @ManyToMany
    @JoinTable(name = "Product_Category", joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Autowired
    private Set<Category> categories;


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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
