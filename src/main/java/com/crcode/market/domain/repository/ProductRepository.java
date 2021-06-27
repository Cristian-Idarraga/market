package com.crcode.market.domain.repository;

import java.util.List;
import java.util.Optional;
import com.crcode.market.domain.Product;

public interface ProductRepository { // Indicamos el nombre de los metodos que tienen que implementar todos los que
										// tengan que usar productos
	List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
