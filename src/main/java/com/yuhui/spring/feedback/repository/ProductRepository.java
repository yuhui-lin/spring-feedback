package com.yuhui.spring.feedback.repository;

import com.yuhui.spring.feedback.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

