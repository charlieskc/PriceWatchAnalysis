package com.charlie.pw.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charlie.pw.vo.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	    public Product findByName(String name);
	    public List<Product> findByBrand(String brand);

	}