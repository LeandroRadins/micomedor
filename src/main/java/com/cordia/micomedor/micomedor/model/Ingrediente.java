package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ingrediente")
    @SequenceGenerator(name = "seq_ingrediente", allocationSize = 1)
    private Long id_ingrediente;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "ingredientes")
    private Set<Comida> comidas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_tipo_ingrediente")
    private TipoIngrediente tipoIngrediente;

    public Ingrediente() {

    }

    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(Long id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(Set<Comida> comidas) {
        this.comidas = comidas;
    }

    public TipoIngrediente getTipoIngrediente() {
        return tipoIngrediente;
    }

    public void setTipoIngrediente(TipoIngrediente tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingrediente)) return false;
        Ingrediente that = (Ingrediente) o;
        return getId_ingrediente().equals(that.getId_ingrediente()) && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getComidas(), that.getComidas()) && Objects.equals(getTipoIngrediente(), that.getTipoIngrediente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_ingrediente(), getNombre(), getComidas(), getTipoIngrediente());
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id_ingrediente=" + id_ingrediente +
                ", nombre='" + nombre + '\'' +
                ", comidas=" + comidas +
                ", tipoIngrediente=" + tipoIngrediente +
                '}';
    }
}
