/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Leandro
 *
 */
@Entity
@DiscriminatorValue(value = "DONANTE")
public class Donante extends Usuario {

	@OneToMany(mappedBy = "donante")
	private Set<Donacion> donaciones = new HashSet<>();
}
