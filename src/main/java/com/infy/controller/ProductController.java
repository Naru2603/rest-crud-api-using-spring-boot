package com.infy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.infy.util.Constants.*;

import com.infy.entity.ProductEntity;
import com.infy.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<ProductEntity>> getproducts() {

		log.info("Request received to fetch all Products");
		List<ProductEntity> prodList = productService.getAllProducts();
		return new ResponseEntity<List<ProductEntity>>(prodList, HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody ProductEntity product) {

		log.info("Request received to store the Product : {}", product);
		String res = (productService.createProduct(product)) ? SUCCESSFULLY_STORED: ERROR_WHILE_STORING;
		return new ResponseEntity<String>(res, HttpStatus.CREATED);

	}
}
