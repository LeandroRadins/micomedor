package com.cordia.micomedor.micomedor.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Leandro
 *
 */

@Entity
@Table(name = "tipo_donacion")
public class TipoDonacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipoDonacion")
	@SequenceGenerator(name = "seq_tipoDonacion", allocationSize = 1)
	private Long id_tipoDonacion;

	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "tipo_donacion")
	private Set<Donacion> donaciones;

}
