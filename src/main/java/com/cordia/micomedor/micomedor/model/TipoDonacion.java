package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Leandro
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
    private Set<Donacion> donaciones = new HashSet<>();

    public TipoDonacion() {

    }

    public TipoDonacion(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_tipoDonacion() {
        return id_tipoDonacion;
    }

    public void setId_tipoDonacion(Long id_tipoDonacion) {
        this.id_tipoDonacion = id_tipoDonacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Donacion> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(Set<Donacion> donaciones) {
        this.donaciones = donaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDonacion)) return false;
        TipoDonacion that = (TipoDonacion) o;
        return getId_tipoDonacion().equals(that.getId_tipoDonacion()) && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getDonaciones(), that.getDonaciones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_tipoDonacion(), getNombre(), getDonaciones());
    }

    @Override
    public String toString() {
        return "TipoDonacion{" +
                "id_tipoDonacion=" + id_tipoDonacion +
                ", nombre='" + nombre + '\'' +
                ", donaciones=" + donaciones +
                '}';
    }
}
