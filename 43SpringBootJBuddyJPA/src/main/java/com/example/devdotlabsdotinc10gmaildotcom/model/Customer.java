package com.example.devdotlabsdotinc10gmaildotcom.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "customer")
@Entity
@Data
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Products> productses;

    public List<Products> getProductses() {
        return productses;
    }

    public void setProductses(List<Products> productses) {
        this.productses = productses;
    }
}