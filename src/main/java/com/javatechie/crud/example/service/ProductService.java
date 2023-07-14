package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//save product and return it
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	//save products and return the list
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	//find all products and return the list
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	//get product by id and return the product or null
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	//fetch product by name and return product
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	//delete product by id and return string message with confirmation
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed: " + id;
	}
	
	//update product by id and return saved product
	public Product updateProduct(int productId, Product product) {
		Product existingProduct = repository.findById(productId).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
	
}
