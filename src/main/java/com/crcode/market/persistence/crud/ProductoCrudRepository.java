package com.crcode.market.persistence.crud;

import java.util.List;
import java.util.Optional;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.crcode.market.persistence.entity.Producto;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{
	
//	@Query(value = "SELECT * FROM productos WHERE id_categoria=1? ORDER BY nombre ASC") // Por @Query
	List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria); // Por Query Methods
	
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
