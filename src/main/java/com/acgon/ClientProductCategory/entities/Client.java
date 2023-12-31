package com.acgon.ClientProductCategory.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
