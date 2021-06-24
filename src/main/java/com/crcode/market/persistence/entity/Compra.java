package com.crcode.market.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Integer idCompra;

	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "fecha")
	private LocalDateTime fecha;

	@Column(name = "medio_pago")
	private Character medioPago;

	@Column(name = "comentario")
	private String comentario;

	@Column(name = "estado")
	private Character estado;

	@ManyToOne // Desde esta tabla se ve muchos a uno, el'id_cliente', es el nombre de la comuna que hace como foreigns
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false) // Para que no permita crear nuevos clientes en esta relacion
	private Cliente cliente;
	
	@OneToMany(mappedBy = "producto")
	private List<ComprasProducto> productos;

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Character getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(Character medioPago) {
		this.medioPago = medioPago;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}
}
