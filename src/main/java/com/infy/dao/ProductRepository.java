package com.infy.dao;

import java.util.List;

import com.infy.entity.ProductEntity;

public interface ProductRepository {

	public List<ProductEntity> getAllProductsFromDb();

	public boolean createProduct(ProductEntity product);
}
