package br.edu.ifpb.kramerclothing.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int duration;
    private double basePrice;
    private int numOfClothes;

    public Plan() {
    }

    public Plan(int duration, double basePrice, int numOfClothes) {
        this.duration = duration;
        this.basePrice = basePrice;
        this.numOfClothes = numOfClothes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getNumOfClothes() {
        return numOfClothes;
    }

    public void setNumOfClothes(int numOfClothes) {
        this.numOfClothes = numOfClothes;
    }
}
