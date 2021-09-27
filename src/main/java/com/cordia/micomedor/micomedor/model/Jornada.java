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
@Table(name = "jornadas")
public class Jornada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jornada")
    @SequenceGenerator(name = "seq_jornada", allocationSize = 1)
    private Long id_jornada;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    //Relaciones
    //Una jornada pertenece a un solo comedor
    @ManyToOne
    @JoinColumn(name = "id_comedor")
    private Comedor comedor;

    @ManyToMany
    @JoinTable(name = "jornada_plato", joinColumns = {@JoinColumn(name = "id_jornada", referencedColumnName = "id_jornada")},
            inverseJoinColumns = {@JoinColumn(name = "id_plato", referencedColumnName = "id_plato")})
    private Set<Plato> platos = new HashSet<>();

    public Jornada() {
    }

    public Jornada(Date fecha, Comedor comedor) {
        this.fecha = fecha;
        this.comedor = comedor;
    }

    public Long getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(Long id_jornada) {
        this.id_jornada = id_jornada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    public Set<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(Set<Plato> platos) {
        this.platos = platos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jornada)) return false;
        Jornada jornada = (Jornada) o;
        return getId_jornada().equals(jornada.getId_jornada()) && Objects.equals(getFecha(), jornada.getFecha()) && Objects.equals(getComedor(), jornada.getComedor()) && Objects.equals(getPlatos(), jornada.getPlatos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_jornada(), getFecha(), getComedor(), getPlatos());
    }

    @Override
    public String toString() {
        return "Jornada{" +
                "id_jornada=" + id_jornada +
                ", fecha=" + fecha +
                ", comedor=" + comedor +
                ", platos=" + platos +
                '}';
    }
}
