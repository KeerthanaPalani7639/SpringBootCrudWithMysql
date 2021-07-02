package com.example.demo.controller;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;




@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/create")
	public Product create(@RequestBody Product product)
	{
		return productservice.saveProduct(product);
		
	}
	
@PostMapping("/createall")
	public List<Product> createProducts(@RequestBody List<Product> product)
	{
		return productservice.saveProducts(product);
		
	}

	@GetMapping("/readbyid/{id}")
	public Optional<Product> ReadById(@PathVariable int id)
	{
		return productservice.getProductById(id);
		
	}
	
	@GetMapping("/readall")
	public List<Product> ReadAll()
	{
		return productservice.getProducts();
	}
	
	@GetMapping("/readbyname/{name}")
	public Product ReadByName(@PathVariable String name)
	{
		return productservice.getProductByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id)
	{
		return productservice.deleteProduct(id);
	}
	
	@PutMapping("/update")
	public Product update(@RequestBody Product existingproduct)
	{
		return productservice.updateProduct(existingproduct);
		
	}

}
