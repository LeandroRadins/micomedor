package com.cordia.micomedor.micomedor.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_ingrediente")
public class TipoIngrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipoIngrediente")
	private Long id_tipoIngrediente;

	@Column(name = "nombre")
	private String nombre;

	public TipoIngrediente() {

	}

	public TipoIngrediente(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id_tipoIngrediente
	 */
	public Long getId_tipoIngrediente() {
		return id_tipoIngrediente;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param id_tipoIngrediente the id_tipoIngrediente to set
	 */
	public void setId_tipoIngrediente(Long id_tipoIngrediente) {
		this.id_tipoIngrediente = id_tipoIngrediente;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_tipoIngrediente, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TipoIngrediente))
			return false;
		TipoIngrediente other = (TipoIngrediente) obj;
		return Objects.equals(id_tipoIngrediente, other.id_tipoIngrediente) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipoIngrediente [id_tipoIngrediente=");
		builder.append(id_tipoIngrediente);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

}
