package com.javaassignment1.productmgmtservice.controller;
import com.javaassignment1.productmgmtservice.service.ProductService;
import com.javaassignment1.productmgmtservice.entity.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	 @Autowired
	    private ProductService productService;

	    @PostMapping("/add")
	    public ResponseEntity<String> addProduct(@RequestBody Product product) {
	        productService.addProduct(product);
	        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
	    }

	    @GetMapping("/findAll")
	    public List<Product> getProducts() {
	        return productService.getProducts();
	    }

	    @GetMapping("/generateBill")
	    public Map<String, Object> generateBill() {
	        return productService.generateBills();
	    }
	    @DeleteMapping("/delete/{productId}")
	    public ResponseEntity<String> deleteProductById(@PathVariable String productId) {
	        if (productService.deleteProductById(productId)) {
	            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Product with ID " + productId + " not found", HttpStatus.NOT_FOUND);
	        }
	    }
	}


