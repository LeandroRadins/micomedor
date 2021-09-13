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
@Table(name = "comidas")
public class Comida {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comidas")
	@SequenceGenerator(name = "seq_comidas", allocationSize = 1)
	private Long id_comida;

	@Column(name = "nombre")
	private String nombre;

	// #TODO: agregar la relacion de comida con plato y comida con ingrediente.

	public Comida() {

	}

	public Comida(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id_comida
	 */
	public Long getId_comida() {
		return id_comida;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param id_comida the id_comida to set
	 */
	public void setId_comida(Long id_comida) {
		this.id_comida = id_comida;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_comida, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comida))
			return false;
		Comida other = (Comida) obj;
		return Objects.equals(id_comida, other.id_comida) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comida [id_comida=");
		builder.append(id_comida);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

}
