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
@Table(name = "platos")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plato")
    @SequenceGenerator(name = "seq_plato", allocationSize = 1)
    private Long id_plato;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "platos")
    private Set<Jornada> jornadas = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "plato_comida", joinColumns = {@JoinColumn(name = "id_plato", referencedColumnName = "id_plato")},
            inverseJoinColumns = {@JoinColumn(name = "id_comida", referencedColumnName = "id_comida")})
    private Set<Comida> comidas = new HashSet<>();

    public Plato() {

    }

    public Plato(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_plato() {
        return id_plato;
    }

    public void setId_plato(Long id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(Set<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    public Set<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(Set<Comida> comidas) {
        this.comidas = comidas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plato)) return false;
        Plato plato = (Plato) o;
        return getId_plato().equals(plato.getId_plato()) && Objects.equals(getNombre(), plato.getNombre()) && Objects.equals(getJornadas(), plato.getJornadas()) && Objects.equals(getComidas(), plato.getComidas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_plato(), getNombre(), getJornadas(), getComidas());
    }

    @Override
    public String toString() {
        return "Plato{" +
                "id_plato=" + id_plato +
                ", nombre='" + nombre + '\'' +
                ", jornadas=" + jornadas +
                ", comidas=" + comidas +
                '}';
    }
}
