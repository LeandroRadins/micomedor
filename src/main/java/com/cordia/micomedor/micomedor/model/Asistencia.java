package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Leandro
 */
@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_asis")
    @SequenceGenerator(name = "seq_asis", allocationSize = 1)
    private Long id_asistencia;

    @Column(name = "dia")
    @Temporal(TemporalType.DATE)
    private Date dia;

    @Column(name = "asistencia")
    private boolean asistencia;

    public Asistencia() {

    }

    public Asistencia(Date dia, boolean asistencia, Usuario usuario) {
        this.dia = dia;
        this.asistencia = true;
    }

    public Long getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(Long id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asistencia that = (Asistencia) o;
        return isAsistencia() == that.isAsistencia() && Objects.equals(getId_asistencia(), that.getId_asistencia()) && Objects.equals(getDia(), that.getDia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_asistencia(), getDia(), isAsistencia());
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "id_asistencia=" + id_asistencia +
                ", dia=" + dia +
                ", asistencia=" + asistencia +
                '}';
    }
}
