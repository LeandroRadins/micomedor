/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

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

}
