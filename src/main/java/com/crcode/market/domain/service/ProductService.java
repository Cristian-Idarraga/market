package com.crcode.market.domain.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crcode.market.domain.Product;
import com.crcode.market.domain.repository.ProductRepository;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    public Product update(Product product) throws Exception {
    	Optional<Product> productFind = this.getProduct(product.getProductId());
    	if(productFind.isPresent()) {
    		return this.productRepository.save(product);
    	}
    	throw new Exception("No encontrado");
    }
    
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
//		if(getProduct(productId).isPresent()) {
//			productRepository.delete(productId);
//			return true;
//		} else {
//			return false;
//		}
	}

}
