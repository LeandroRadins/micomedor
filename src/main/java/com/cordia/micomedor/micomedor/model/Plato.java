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
@Table(name = "platos")
public class Plato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plato")
	@SequenceGenerator(name = "seq_plato", allocationSize = 1)
	private Long id_plato;

	@Column(name = "nombre")
	private String nombre;

	public Plato() {

	}

	/**
	 * @param id_plato
	 * @param nombre
	 */
	public Plato(Long id_plato, String nombre) {
		this.id_plato = id_plato;
		this.nombre = nombre;
	}

	/**
	 * @return the id_plato
	 */
	public Long getId_plato() {
		return id_plato;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param id_plato the id_plato to set
	 */
	public void setId_plato(Long id_plato) {
		this.id_plato = id_plato;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_plato, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Plato))
			return false;
		Plato other = (Plato) obj;
		return Objects.equals(id_plato, other.id_plato) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Plato [id_plato=");
		builder.append(id_plato);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

}
