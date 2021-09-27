package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tipo_ingrediente")
public class TipoIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipoIngrediente")
    private Long id_tipoIngrediente;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "tipoIngrediente")
    private Set<Ingrediente> ingredientes = new HashSet<>();

    public TipoIngrediente() {

    }

    public TipoIngrediente(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_tipoIngrediente() {
        return id_tipoIngrediente;
    }

    public void setId_tipoIngrediente(Long id_tipoIngrediente) {
        this.id_tipoIngrediente = id_tipoIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(o instanceof TipoIngrediente)) return false;
        TipoIngrediente that = (TipoIngrediente) o;
        return getId_tipoIngrediente().equals(that.getId_tipoIngrediente()) && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getIngredientes(), that.getIngredientes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_tipoIngrediente(), getNombre(), getIngredientes());
    }

    @Override
    public String toString() {
        return "TipoIngrediente{" +
                "id_tipoIngrediente=" + id_tipoIngrediente +
                ", nombre='" + nombre + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
