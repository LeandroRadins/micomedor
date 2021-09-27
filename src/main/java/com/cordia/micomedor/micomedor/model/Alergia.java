package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "alergias")
public class Alergia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alergia")
    @SequenceGenerator(name = "seq_alergia", allocationSize = 1)
    private Long id_alergia;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private Ficha ficha;

    public Alergia() {
    }

    public Alergia(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_alergia() {
        return id_alergia;
    }

    public void setId_alergia(Long id_alergia) {
        this.id_alergia = id_alergia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(o instanceof Alergia)) return false;
        Alergia alergia = (Alergia) o;
        return getId_alergia().equals(alergia.getId_alergia()) && Objects.equals(getNombre(), alergia.getNombre()) && Objects.equals(getFicha(), alergia.getFicha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_alergia(), getNombre(), getFicha());
    }

    @Override
    public String toString() {
        return "Alergia{" +
                "id_alergia=" + id_alergia +
                ", nombre='" + nombre + '\'' +
                ", ficha=" + ficha +
                '}';
    }
}
