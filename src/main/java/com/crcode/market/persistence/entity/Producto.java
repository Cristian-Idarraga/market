package com.crcode.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id // Porque es la llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Genera un numero unico
	@Column(name = "id_producto")
	private Integer idProducto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "id_categoria")
	private Integer idCategoria;

	@Column(name = "codigo_barras")
	private String codigoBarras;

	@Column(name = "precio_venta")
	private Double precioVenta;

	@Column(name = "cantidad_stock")
	private Integer cantidadStock;

	@Column(name = "estado")
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private Categoria categoria;

	//Podemos crear las compras, para saber que productos se ven involucrados en ciertas compras
	
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
