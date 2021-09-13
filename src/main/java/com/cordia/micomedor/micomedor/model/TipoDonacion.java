package com.cordia.micomedor.micomedor.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro
 *
 */

@Entity
@Table(name = "tipo_donacion")
public class TipoDonacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipoDonacion")
	@SequenceGenerator(name = "seq_tipoDonacion", allocationSize = 1)
	private Long id_tipoDonacion;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "tipo_donacion")
	private Set<Donacion> donaciones;

	public TipoDonacion() {

	}

	public TipoDonacion(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id_tipoDonacion
	 */
	public Long getId_tipoDonacion() {
		return id_tipoDonacion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the donaciones
	 */
	public Set<Donacion> getDonaciones() {
		return donaciones;
	}

	/**
	 * @param id_tipoDonacion the id_tipoDonacion to set
	 */
	public void setId_tipoDonacion(Long id_tipoDonacion) {
		this.id_tipoDonacion = id_tipoDonacion;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param donaciones the donaciones to set
	 */
	public void setDonaciones(Set<Donacion> donaciones) {
		this.donaciones = donaciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donaciones, id_tipoDonacion, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TipoDonacion))
			return false;
		TipoDonacion other = (TipoDonacion) obj;
		return Objects.equals(donaciones, other.donaciones) && Objects.equals(id_tipoDonacion, other.id_tipoDonacion)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipoDonacion [id_tipoDonacion=");
		builder.append(id_tipoDonacion);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", donaciones=");
		builder.append(donaciones);
		builder.append("]");
		return builder.toString();
	}

}
