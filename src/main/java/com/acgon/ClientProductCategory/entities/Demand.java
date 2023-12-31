package com.acgon.ClientProductCategory.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    public Demand(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Demand() {}

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
