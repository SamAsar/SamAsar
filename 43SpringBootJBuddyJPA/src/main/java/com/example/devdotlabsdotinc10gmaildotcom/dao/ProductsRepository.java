package com.example.devdotlabsdotinc10gmaildotcom.dao;

import com.example.devdotlabsdotinc10gmaildotcom.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}