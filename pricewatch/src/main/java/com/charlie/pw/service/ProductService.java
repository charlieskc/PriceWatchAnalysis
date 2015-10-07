package com.charlie.pw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.pw.vo.Product;

@Service
public class ProductService {
	 @Autowired
	 private ProductRepository repository;

	 public Product findByName(String name){
		 return repository.findByName(name);
	 }

}
