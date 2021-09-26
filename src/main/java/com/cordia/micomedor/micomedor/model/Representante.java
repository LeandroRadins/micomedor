/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Leandro
 *
 */
@Entity
@DiscriminatorValue(value = "REPRESENTANTE")
public class Representante extends Usuario {

	@ManyToOne
	@JoinColumn(name = "id_comedor")
	private Comedor comedor;
}
