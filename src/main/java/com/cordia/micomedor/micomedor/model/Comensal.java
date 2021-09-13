/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Leandro
 *
 */

@Entity
@DiscriminatorValue(value = "COMENSAL")
public class Comensal extends Usuario {

	@Column(name = "marcaAsistencia")
	private boolean marcaAsistencia;

	@OneToMany(mappedBy = "comensal")
	private Set<Asistencia> asistencias;

	public Comensal() {

	}

	/**
	 * @param marcaAsistencia
	 */
	public Comensal(boolean marcaAsistencia) {
		this.marcaAsistencia = marcaAsistencia;
	}

	/**
	 * @return the marcaAsistencia
	 */
	public boolean isMarcaAsistencia() {
		return marcaAsistencia;
	}

	/**
	 * @param marcaAsistencia the marcaAsistencia to set
	 */
	public void setMarcaAsistencia(boolean marcaAsistencia) {
		this.marcaAsistencia = marcaAsistencia;
	}

	/**
	 * @return the asistencias
	 */
	public Set<Asistencia> getAsistencias() {
		return asistencias;
	}

	/**
	 * @param asistencias the asistencias to set
	 */
	public void setAsistencias(Set<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(asistencias, marcaAsistencia);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Comensal))
			return false;
		Comensal other = (Comensal) obj;
		return Objects.equals(asistencias, other.asistencias) && marcaAsistencia == other.marcaAsistencia;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comensal [marcaAsistencia=");
		builder.append(marcaAsistencia);
		builder.append(", asistencias=");
		builder.append(asistencias);
		builder.append("]");
		return builder.toString();
	}

}
