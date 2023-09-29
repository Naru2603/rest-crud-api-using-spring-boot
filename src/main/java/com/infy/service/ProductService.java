package com.infy.service;

import java.util.List;

import com.infy.entity.ProductEntity;

public interface ProductService {

	public List<ProductEntity> getAllProducts();

	public boolean createProduct(ProductEntity product);
}
