package br.edu.ifpb.kramerclothing.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_kit")
public class Kit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double factor;

    public Kit() {
    }

    public Kit(String name, double factor) {
        this.name = name;
        this.factor = factor;
    }

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

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }
}
