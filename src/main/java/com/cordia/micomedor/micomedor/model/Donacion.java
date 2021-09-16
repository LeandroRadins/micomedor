/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro
 *
 */
@Entity
@Table(name = "donaciones")
public class Donacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_donacion")
	@SequenceGenerator(name = "seq_donacion", allocationSize = 1)
	private Long id_donacion;

	@ManyToOne
	@JoinColumn(name = "tipo_donacion")
	private TipoDonacion tipo_donacion;

	@ManyToOne
	@JoinColumn(name = "comedor")
	private Comedor comedor;

	public Donacion() {

	}

	public Donacion(TipoDonacion tipo_donacion) {
		this.tipo_donacion = tipo_donacion;
	}

	/**
	 * @return the id_donacion
	 */
	public Long getId_donacion() {
		return id_donacion;
	}

	/**
	 * @return the tipo_donacion
	 */
	public TipoDonacion getTipo_donacion() {
		return tipo_donacion;
	}

	/**
	 * @return the comedor
	 */
	public Comedor getComedor() {
		return comedor;
	}

	/**
	 * @param id_donacion the id_donacion to set
	 */
	public void setId_donacion(Long id_donacion) {
		this.id_donacion = id_donacion;
	}

	/**
	 * @param tipo_donacion the tipo_donacion to set
	 */
	public void setTipo_donacion(TipoDonacion tipo_donacion) {
		this.tipo_donacion = tipo_donacion;
	}

	/**
	 * @param comedor the comedor to set
	 */
	public void setComedor(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comedor, id_donacion, tipo_donacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Donacion))
			return false;
		Donacion other = (Donacion) obj;
		return Objects.equals(comedor, other.comedor) && Objects.equals(id_donacion, other.id_donacion)
				&& Objects.equals(tipo_donacion, other.tipo_donacion);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Donacion [id_donacion=");
		builder.append(id_donacion);
		builder.append(", tipo_donacion=");
		builder.append(tipo_donacion);
		builder.append(", comedor=");
		builder.append(comedor);
		builder.append("]");
		return builder.toString();
	}

}
