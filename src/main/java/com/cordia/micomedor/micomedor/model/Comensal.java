package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Leandro
 */

@Entity
@DiscriminatorValue(value = "COMENSAL")
public class Comensal extends Usuario {

    @Column(name = "marca_asistencia")
    private boolean marcaAsistencia;

    // Relaciones
    // Un comensal tiene muchas asistencias, especificamente 365 asistencias
    @OneToMany(mappedBy = "comensal")
    private Set<Asistencia> asistencias = new HashSet<>();

    // Un comensal puede acceder a un solo comedor en simultaneo
    @ManyToOne
    @JoinColumn(name = "id_comedor")
    private Comedor comedor;

    @OneToOne
    @JoinColumn(name = "id_ficha")
    private Ficha ficha;

    public Comensal() {

    }

    public Comensal(int dni, String nombre, String apellido, Date fechaNac, String email, String telefono, boolean marcaAsistencia) {
        super(dni, nombre, apellido, fechaNac, email, telefono);
        this.marcaAsistencia = marcaAsistencia;
    }

    public Comensal(boolean marcaAsistencia) {
        this.marcaAsistencia = marcaAsistencia;
    }

    public boolean isMarcaAsistencia() {
        return marcaAsistencia;
    }

    public void setMarcaAsistencia(boolean marcaAsistencia) {
        this.marcaAsistencia = marcaAsistencia;
    }

    public Set<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comensal)) return false;
        if (!super.equals(o)) return false;
        Comensal comensal = (Comensal) o;
        return isMarcaAsistencia() == comensal.isMarcaAsistencia() && Objects.equals(getAsistencias(), comensal.getAsistencias()) && Objects.equals(getComedor(), comensal.getComedor()) && Objects.equals(getFicha(), comensal.getFicha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isMarcaAsistencia(), getAsistencias(), getComedor(), getFicha());
    }

    @Override
    public String toString() {
        return "Comensal{" +
                "marcaAsistencia=" + marcaAsistencia +
                ", asistencias=" + asistencias +
                ", comedor=" + comedor +
                ", ficha=" + ficha +
                '}';
    }
}
