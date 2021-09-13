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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Leandro
 *
 */
@Entity
@Table(name = "asistencias")
public class Asistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_asis")
	@SequenceGenerator(name = "seq_asis", allocationSize = 1, initialValue = 1)
	private Long id_asistencia;

	@Column(name = "dia")
	@Temporal(TemporalType.DATE)
	private Date dia;

	@Column(name = "asistencia")
	private boolean asistencia;

	@ManyToOne
	@JoinColumn(name = "id_comensal")
	private Comensal comensal;

	public Asistencia() {

	}

	public Asistencia(Date dia, boolean asistencia, Comensal comensal) {
		this.dia = dia;
		this.asistencia = true;
		this.comensal = comensal;
	}

	/**
	 * @return the id_asistencia
	 */
	public Long getId_asistencia() {
		return id_asistencia;
	}

	/**
	 * @return the dia
	 */
	public Date getDia() {
		return dia;
	}

	/**
	 * @return the asistencia
	 */
	public boolean isAsistencia() {
		return asistencia;
	}

	/**
	 * @param id_asistencia the id_asistencia to set
	 */
	public void setId_asistencia(Long id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(Date dia) {
		this.dia = dia;
	}

	/**
	 * @param asistencia the asistencia to set
	 */
	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}

	/**
	 * @return the comensal
	 */
	public Comensal getComensal() {
		return comensal;
	}

	/**
	 * @param comensal the comensal to set
	 */
	public void setComensal(Comensal comensal) {
		this.comensal = comensal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asistencia, comensal, dia, id_asistencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Asistencia))
			return false;
		Asistencia other = (Asistencia) obj;
		return asistencia == other.asistencia && Objects.equals(comensal, other.comensal)
				&& Objects.equals(dia, other.dia) && Objects.equals(id_asistencia, other.id_asistencia);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Asistencia [id_asistencia=");
		builder.append(id_asistencia);
		builder.append(", dia=");
		builder.append(dia);
		builder.append(", asistencia=");
		builder.append(asistencia);
		builder.append(", comensal=");
		builder.append(comensal);
		builder.append("]");
		return builder.toString();
	}

}
