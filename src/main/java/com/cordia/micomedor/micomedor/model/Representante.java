/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Leandro
 *
 */
@Entity
@DiscriminatorValue(value = "REPRESENTANTE")
public class Representante extends Usuario {
}
