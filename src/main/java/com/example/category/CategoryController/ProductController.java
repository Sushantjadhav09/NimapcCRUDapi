package com.example.category.CategoryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.category.CategoryRepository.ProductRepository;
import com.example.category.CategoryService.ProductService;
import com.example.category.Model.Categoryy;
import com.example.category.Model.Product;
import com.example.dto.ProductRequest;

@RestController
@RequestMapping
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	 @GetMapping("/getProductById/{id}")
		public Product getProductById(@PathVariable Long id) {
			
			return productService.getProducttById(id);
		}
	 
	 @GetMapping("/getallProduct")
		public List <Product>getallProduct() {
			
			return productService.getaLLProduct();
		}
	 

	 
	 
	 @PostMapping("/addProduct")
		public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
		    try {
		        // Save product
		        productService.saveProduct(request.getCategoryId(), request.getProductName(), request.getPrice());
		        return ResponseEntity.ok("Product created successfully");
		    } catch (RuntimeException e) {
		        return ResponseEntity.badRequest().body(e.getMessage());
		    }
	 }
	 
	 @DeleteMapping("/DeleteProduct/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	        try {
	            productService.deleteProduct(id);
	            return ResponseEntity.ok("Product deleted successfully");
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(404).body(e.getMessage());  // 404 if product not found
	        }
	    }
//	 
//	 @PutMapping("/updateProduct/{id}")
//	 public ResponseEntity<Product> updateProduct(
//	         @PathVariable Long id,
//	         @RequestBody ProductRequest productRequest) {
//	     try {
//	         // Call the service to update the product
//	         Product updatedProduct = productService.updateProduct(
//	                 id, 
//	                 productRequest.getProductName(),
//	                 productRequest.getPrice(),
//	                 productRequest.getCategoryId());
//
//	         // Return the updated product in the response
//	         return ResponseEntity.ok(updatedProduct);
//	     } catch (RuntimeException e) {
//	         return ResponseEntity.status(404).body(null); // Product not found (404)
//	     }
//	 }
	 
	 @PutMapping("/updateProduct/{id}")
		public String updateCategory(@RequestBody Product newProduct,@PathVariable("id") Long id) {
			
		 productService.updateProductt(id, newProduct);
			
			return "record updated successfully";
		}


}
