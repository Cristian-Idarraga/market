package com.crcode.market.persistence;

import java.util.List;
import java.util.Optional;
import com.crcode.market.persistence.crud.ProductoCrudRepository;
import com.crcode.market.persistence.entity.Producto;

public class ProductoRepository {
	private ProductoCrudRepository productoCrudRepository;

	public List<Producto> getAll() {
		return (List<Producto>) productoCrudRepository.findAll();
	}

	public List<Producto> getByCategoria(int idCatregoria) {
		return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCatregoria);
	}
	
	public Optional<List<Producto>> getByStockAndEstado(int cantidadStock, boolean estado){
		return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, estado);
	}
}
