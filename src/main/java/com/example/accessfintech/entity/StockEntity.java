package com.example.accessfintech.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STOCKS")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lowest_price")
    private Double lowestPrice;

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

    public Double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntity that = (StockEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lowestPrice, that.lowestPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lowestPrice);
    }

    @Override
    public String toString() {
        return "StockEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lowestPrice=" + lowestPrice +
                '}';
    }
}
