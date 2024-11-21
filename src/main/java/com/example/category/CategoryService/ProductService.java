package com.example.category.CategoryService;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.category.CategoryRepository.CategoryRepository;
import com.example.category.CategoryRepository.ProductRepository;
import com.example.category.Model.Categoryy;
import com.example.category.Model.Product;
import com.example.dto.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	 @Autowired
	    private CategoryRepository categoryRepository;
	 


	public Product getProducttById(Long id) {
		return productRepository.findById(id).get();
	}

	public List<Product> getaLLProduct() {
		return productRepository.findAll();
	}

	
	
	public void saveProduct(Long categoryId, String productName, Double price) {
	    // Fetch the category from the database
	    Categoryy category = categoryRepository.findById(categoryId)
	            .orElseThrow(() -> new RuntimeException("Category not found"));

	    // Create and set the Product fields
	    Product product = new Product();
	    product.setCategory(category); // Set the category
	    product.setName(productName); // Set the product name
	    product.setPrice(price); // Set the product price

	    // Save the product (ID will be auto-generated)
	    productRepository.save(product);
	}
	
	 public void deleteProduct(Long id) {
	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	        productRepository.delete(product);  // Deletes the product from the database
	    }
	 
	 
	 
	 public Product updateProduct(Long id, String productName, Double price, Long categoryId) {
	        // Find the product by ID
	        Product existingProduct = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        // Find the category by ID
	        Categoryy category = categoryRepository.findById(categoryId)
	                .orElseThrow(() -> new RuntimeException("Category not found"));

	        // Update product details
	        existingProduct.setName(productName);
	        existingProduct.setPrice(price);
	        existingProduct.setCategory(category);

	        // Save the updated product
	        return productRepository.save(existingProduct);
	    }
	 
	 
//	 public Product updateProductt(Long id, String productName, Double price, Long categoryId) {
//		    // Check if the product exists
//		    Product existingProduct = productRepository.findById(id)
//		            .orElseThrow(() -> new RuntimeException("Product not found"));
//
//		    // Proceed with updating the product
//		    Categoryy category = categoryRepository.findById(categoryId)
//		            .orElseThrow(() -> new RuntimeException("Category not found"));
//
//		    existingProduct.setName(productName);
//		    existingProduct.setPrice(price);
//		    existingProduct.setCategory(category);
//
//		    return productRepository.save(existingProduct);
//		}
	 
	 public Product updateProductt(Long id, Product newProduct) {
		  Product currentDbvalues = productRepository.findById(id).get();
		  currentDbvalues.setId(newProduct.getId());
		  currentDbvalues.setName(newProduct.getName());
		  currentDbvalues.setPrice(newProduct.getPrice());
		return productRepository.save(currentDbvalues);
	}
	 



}
