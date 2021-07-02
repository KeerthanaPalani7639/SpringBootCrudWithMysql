package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;





@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product)
	{
		return repository.save(product) ;
		
	}
	
	public List<Product> saveProducts(List<Product> products)
	{
		return repository.saveAll(products);
		
	}
	public List<Product> getProducts()
	{
		return repository.findAll();
		
	}
	public Optional<Product> getProductById(int id)
	{
		return repository.findById(id);
		
	}
	
public Product getProductByName(String name)
{
	return repository.findByName(name);
	
}

public String deleteProduct(int id)
{
	repository.deleteById(id);
	return "Product Deleted"+id;
}

public Product updateProduct(Product product)
{
	Product existingproduct=repository.findById(product.getId()).orElse(product);
	existingproduct.setName(product.getName());
	existingproduct.setQuantity(product.getQuantity());
	existingproduct.setPrice(product.getPrice());
	return repository.save(existingproduct) ;

// @formatter:on

 


}

}
