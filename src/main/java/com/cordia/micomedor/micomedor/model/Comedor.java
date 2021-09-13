/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Objects;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comedores")
	@SequenceGenerator(name = "seq_comedores", allocationSize = 1)
	private Long id_comedor;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "correo")
	private String correo;

	@Column(name = "telefono")
	private String telefono;

	public Comedor() {

	}

	public Comedor(String nombre, String direccion, String correo, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
	}

	/**
	 * @return the id_comedor
	 */
	public Long getId_comedor() {
		return id_comedor;
	}

	/**
	 * @param id_comedor the id_comedor to set
	 */
	public void setId_comedor(Long id_comedor) {
		this.id_comedor = id_comedor;
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
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(correo, direccion, id_comedor, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comedor))
			return false;
		Comedor other = (Comedor) obj;
		return Objects.equals(correo, other.correo) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(id_comedor, other.id_comedor) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comedor [id_comedor=");
		builder.append(id_comedor);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", correo=");
		builder.append(correo);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append("]");
		return builder.toString();
	}

}
