package br.edu.ifpb.kramerclothing.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String devolutionDate;
    private String status;
    private double price;
    private String kitId;
    private String planId;

    @ElementCollection
    private List<String> clothesIds;

    private String userId;

    public Order() {
    }

    public Order(String date, String devolutionDate, String status, double price, String kitId, String planId, List<String> clothesIds, String userId) {
        this.date = date;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.price = price;
        this.kitId = kitId;
        this.planId = planId;
        this.clothesIds = clothesIds;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getKitId() {
        return kitId;
    }

    public void setKitId(String kitId) {
        this.kitId = kitId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public List<String> getClothesIds() {
        return clothesIds;
    }

    public void setClothesIds(List<String> clothesIds) {
        this.clothesIds = clothesIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
