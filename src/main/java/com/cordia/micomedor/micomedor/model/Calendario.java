/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Leandro
 *
 */
@Entity
@Table(name = "calendario")
public class Calendario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_calendario")
	@SequenceGenerator(name = "seq_calendario", allocationSize = 1, initialValue = 1)
	private Long id_calendario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	public Calendario() {

	}

	public Calendario(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the id_calendario
	 */
	public Long getId_calendario() {
		return id_calendario;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param id_calendario the id_calendario to set
	 */
	public void setId_calendario(Long id_calendario) {
		this.id_calendario = id_calendario;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, id_calendario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Calendario))
			return false;
		Calendario other = (Calendario) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id_calendario, other.id_calendario);
	}

	@Override
	public String toString() {
		return "Calendario [id_calendario=" + id_calendario + ", fecha=" + fecha + "]";
	}

}
