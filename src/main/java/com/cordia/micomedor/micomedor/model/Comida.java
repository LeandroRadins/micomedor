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
@Table(name = "comidas")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comidas")
    @SequenceGenerator(name = "seq_comidas", allocationSize = 1)
    private Long id_comida;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "comidas")
    private Set<Plato> platos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "comida_ingrediente", joinColumns = {@JoinColumn(name = "id_comida", referencedColumnName = "id_comida")},
            inverseJoinColumns = {@JoinColumn(name = "id_ingrediente", referencedColumnName = "id_ingrediente")})
    private Set<Ingrediente> ingredientes = new HashSet<>();

    // #TODO: agregar la relacion de comida con ingrediente.

    public Comida() {

    }

    public Comida(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_comida() {
        return id_comida;
    }

    public void setId_comida(Long id_comida) {
        this.id_comida = id_comida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(Set<Plato> platos) {
        this.platos = platos;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comida)) return false;
        Comida comida = (Comida) o;
        return getId_comida().equals(comida.getId_comida()) && Objects.equals(getNombre(), comida.getNombre()) && Objects.equals(getPlatos(), comida.getPlatos()) && Objects.equals(getIngredientes(), comida.getIngredientes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_comida(), getNombre(), getPlatos(), getIngredientes());
    }

    @Override
    public String toString() {
        return "Comida{" +
                "id_comida=" + id_comida +
                ", nombre='" + nombre + '\'' +
                ", platos=" + platos +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
