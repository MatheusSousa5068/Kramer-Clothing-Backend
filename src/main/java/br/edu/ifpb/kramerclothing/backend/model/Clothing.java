package br.edu.ifpb.kramerclothing.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_clothing")
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String brand;
    private String size;
    private String color;
    private String material;
    private String image_icon;

    @ManyToOne
    @JoinColumn(name = "kit_id")
    private Kit kit;

    public Clothing() {
    }

    public Clothing(String description, String brand, String size, String color, String material, Kit kit) {
        this.description = description;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.material = material;
        this.kit = kit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Kit getKit() {
        return kit;
    }

    public void setKit(Kit kit) {
        this.kit = kit;
    }
}
