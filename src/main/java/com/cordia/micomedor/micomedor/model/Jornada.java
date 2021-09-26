package com.cordia.micomedor.micomedor.model;

import java.util.Date;
import javax.persistence.*;

/**
 * @author Leandro
 *
 */
@Entity
@Table(name = "jornadas")
public class Jornada {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jornada")
	@SequenceGenerator(name = "seq_jornada", allocationSize = 1)
	private Long id_jornada;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "id_comedor")
	private Comedor comedor;
	
	//#TODO:  Implementar @ManyToMany

	public Jornada() {

	}

	public Jornada(Date fecha) {
		this.fecha = fecha;
	}

}
