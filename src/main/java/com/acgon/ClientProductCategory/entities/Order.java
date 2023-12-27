package com.acgon.ClientProductCategory.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
