/**
 *
 */
package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Leandro
 *
 */

@Entity
@Table(name = "fichas")
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ficha")
    @SequenceGenerator(name = "seq_ficha", allocationSize = 1)
    private Long id_ficha;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "ficha")
    private Set<Alergia> alergias = new HashSet<>();

    @OneToMany(mappedBy = "ficha")
    private Set<Intolerancia> intolerancias = new HashSet<>();


    public Ficha() {
    }

    public Ficha(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(Long id_ficha) {
        this.id_ficha = id_ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(Set<Alergia> alergias) {
        this.alergias = alergias;
    }

    public Set<Intolerancia> getIntolerancias() {
        return intolerancias;
    }

    public void setIntolerancias(Set<Intolerancia> intolerancias) {
        this.intolerancias = intolerancias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ficha)) return false;
        Ficha ficha = (Ficha) o;
        return getId_ficha().equals(ficha.getId_ficha()) && Objects.equals(getNombre(), ficha.getNombre()) && Objects.equals(getAlergias(), ficha.getAlergias()) && Objects.equals(getIntolerancias(), ficha.getIntolerancias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_ficha(), getNombre(), getAlergias(), getIntolerancias());
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "id_ficha=" + id_ficha +
                ", nombre='" + nombre + '\'' +
                ", alergias=" + alergias +
                ", intolerancias=" + intolerancias +
                '}';
    }
}
