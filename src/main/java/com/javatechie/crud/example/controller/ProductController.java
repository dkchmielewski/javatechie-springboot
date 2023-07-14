package com.javatechie.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
//	@PostMapping
//	public List<Product> addProducts(@RequestBody List<Product> products) {
//		return service.saveProducts(products);
//	}
	
	@GetMapping
	public List<Product> findAllProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
//	@GetMapping("/{name}")
//	public Product findProductByName(@PathVariable String name) {
//		return service.getProductByName(name);
//	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
		return service.updateProduct(id, product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
}
