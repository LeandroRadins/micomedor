/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

	/**
	 * @return the id_donacion
	 */
	public Long getId_donacion() {
		return id_donacion;
	}

	/**
	 * @param id_donacion the id_donacion to set
	 */
	public void setId_donacion(Long id_donacion) {
		this.id_donacion = id_donacion;
	}

}
