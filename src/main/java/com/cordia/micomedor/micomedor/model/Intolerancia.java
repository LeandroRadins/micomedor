package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "intolerancias")
public class Intolerancia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_intolerancia")
    @SequenceGenerator(name = "seq_intolerancia", allocationSize = 1)
    private Long id_intolerancia;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private Ficha ficha;

    public Intolerancia() {
    }

    public Intolerancia(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_intolerancia() {
        return id_intolerancia;
    }

    public void setId_intolerancia(Long id_intolerancia) {
        this.id_intolerancia = id_intolerancia;
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
        if (!(o instanceof Intolerancia)) return false;
        Intolerancia that = (Intolerancia) o;
        return getId_intolerancia().equals(that.getId_intolerancia()) && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getFicha(), that.getFicha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_intolerancia(), getNombre(), getFicha());
    }

    @Override
    public String toString() {
        return "Intolerancia{" +
                "id_intolerancia=" + id_intolerancia +
                ", nombre='" + nombre + '\'' +
                ", ficha=" + ficha +
                '}';
    }
}
