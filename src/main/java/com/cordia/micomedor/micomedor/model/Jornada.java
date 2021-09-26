package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Leandro
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

    //Relaciones
    //Una jornada pertenece a un solo comedor
    @ManyToOne
    @JoinColumn(name = "id_comedor")
    private Comedor comedor;

    public Jornada() {
    }

    public Jornada(Date fecha, Comedor comedor) {
        this.fecha = fecha;
        this.comedor = comedor;
    }

    public Long getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(Long id_jornada) {
        this.id_jornada = id_jornada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jornada jornada = (Jornada) o;
        return id_jornada.equals(jornada.id_jornada) && Objects.equals(fecha, jornada.fecha) && Objects.equals(comedor, jornada.comedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_jornada, fecha, comedor);
    }

    @Override
    public String toString() {
        return "Jornada{" +
                "id_jornada=" + id_jornada +
                ", fecha=" + fecha +
                ", comedor=" + comedor +
                '}';
    }
}
