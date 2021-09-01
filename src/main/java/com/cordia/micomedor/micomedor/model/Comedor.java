/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro
 *
 */
@Entity
@Table(name = "comedores")
public class Comedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqComedores")
	@SequenceGenerator(name = "seqComedores", allocationSize = 1)
	private Long idComedor;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "correo")
	private String correo;

	@Column(name = "telefono")
	private int telefono;

	public Comedor() {

	}

	public Comedor(String nombre, String direccion, String correo, int telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
	}

	/**
	 * @return the idComedor
	 */
	public Long getIdComedor() {
		return idComedor;
	}

	/**
	 * @param idComedor the idComedor to set
	 */
	public void setIdComedor(Long idComedor) {
		this.idComedor = idComedor;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
