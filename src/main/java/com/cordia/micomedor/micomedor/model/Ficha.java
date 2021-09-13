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
@Table(name = "fichas")
public class Ficha {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ficha")
	@SequenceGenerator(name = "seq_ficha", allocationSize = 1)
	private Long id_ficha;

	@Column(name = "nombre")
	private String nombre;
	// #TODO: agregar relaciones con patologias

	public Ficha() {

	}

	public Ficha(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id_ficha
	 */
	public Long getId_ficha() {
		return id_ficha;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param id_ficha the id_ficha to set
	 */
	public void setId_ficha(Long id_ficha) {
		this.id_ficha = id_ficha;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_ficha, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ficha))
			return false;
		Ficha other = (Ficha) obj;
		return Objects.equals(id_ficha, other.id_ficha) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ficha [id_ficha=");
		builder.append(id_ficha);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

}
