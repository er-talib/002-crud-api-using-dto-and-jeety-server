package com.product.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entityes.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {

}
