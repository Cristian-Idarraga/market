package com.crcode.market.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crcode.market.domain.Product;
import com.crcode.market.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		return productService.getProduct(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
		return productService.getByCategory(categoryId).map(products -> new ResponseEntity<>(products, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody Product product) throws Exception{
		try {
			return ResponseEntity.ok(productService.update(product));
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable("id") int productId) {
		if(productService.delete(productId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}