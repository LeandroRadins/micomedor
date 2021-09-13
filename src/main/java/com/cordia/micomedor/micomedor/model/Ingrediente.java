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
@Table(name = "ingredientes")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ingrediente")
	@SequenceGenerator(name = "seq_ingrediente", allocationSize = 1)
	private Long id_ingrediente;

	@Column(name = "nombre")
	private String nombre;

	public Ingrediente() {

	}

	public Ingrediente(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id_ingrediente
	 */
	public Long getId_ingrediente() {
		return id_ingrediente;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param id_ingrediente the id_ingrediente to set
	 */
	public void setId_ingrediente(Long id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_ingrediente, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ingrediente))
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(id_ingrediente, other.id_ingrediente) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingrediente [id_ingrediente=");
		builder.append(id_ingrediente);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

}
