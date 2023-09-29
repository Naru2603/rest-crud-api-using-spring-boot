package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.ProductRepository;
import com.infy.entity.ProductEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepository.getAllProductsFromDb();
	}

	@Override
	public boolean createProduct(ProductEntity product) {
		log.info("inside service - createProduct()");
		return productRepository.createProduct(product);
	}

	
}
