/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * @author Leandro
 *
 */
@Entity
@DiscriminatorValue(value = "DONANTE")
public class Donante extends Usuario {

}
