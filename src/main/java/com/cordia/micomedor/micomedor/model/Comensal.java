/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Leandro
 *
 */

@Entity
@DiscriminatorValue(value = "COMENSAL")
public class Comensal extends Usuario {

	@Column(name = "marcaAsistencia")
	private boolean marcaAsistencia;

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

	@Override
	public int hashCode() {
		return Objects.hash(marcaAsistencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comensal))
			return false;
		Comensal other = (Comensal) obj;
		return marcaAsistencia == other.marcaAsistencia;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comensal [marcaAsistencia=");
		builder.append(marcaAsistencia);
		builder.append("]");
		return builder.toString();
	}

}
