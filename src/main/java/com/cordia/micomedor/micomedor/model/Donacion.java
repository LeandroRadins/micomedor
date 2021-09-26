package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Leandro
 *
 */
@Entity
@Table(name = "donaciones")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_donacion")
    @SequenceGenerator(name = "seq_donacion", allocationSize = 1)
    private Long id_donacion;

    @Column(name = "cantidad")
    private double cantidad;

    // Relaciones

    // Una donacion pertenece a un tipo de donacion. Ejemplo Donacion 1 de tipo "En efectivo"
    @ManyToOne
    @JoinColumn(name = "id_tipo_donacion")
    private TipoDonacion tipo_donacion;

    // Una donacion esta asociada a un solo comedor
    @ManyToOne
    @JoinColumn(name = "id_comedor")
    private Comedor comedor;

    // Una donacion esta hecha por un donante
    @ManyToOne
    @JoinColumn(name = "id_donante")
    private Donante donante;

    public Donacion() {
    }

    public Donacion(double cantidad, TipoDonacion tipo_donacion) {
        this.cantidad = cantidad;
        this.tipo_donacion = tipo_donacion;
    }

    public Long getId_donacion() {
        return id_donacion;
    }

    public void setId_donacion(Long id_donacion) {
        this.id_donacion = id_donacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public TipoDonacion getTipo_donacion() {
        return tipo_donacion;
    }

    public void setTipo_donacion(TipoDonacion tipo_donacion) {
        this.tipo_donacion = tipo_donacion;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donacion)) return false;
        Donacion donacion = (Donacion) o;
        return Double.compare(donacion.getCantidad(), getCantidad()) == 0 && getId_donacion().equals(donacion.getId_donacion()) && Objects.equals(getTipo_donacion(), donacion.getTipo_donacion()) && Objects.equals(getComedor(), donacion.getComedor()) && Objects.equals(getDonante(), donacion.getDonante());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_donacion(), getCantidad(), getTipo_donacion(), getComedor(), getDonante());
    }

    @Override
    public String toString() {
        return "Donacion{" +
                "id_donacion=" + id_donacion +
                ", cantidad=" + cantidad +
                ", tipo_donacion=" + tipo_donacion +
                ", comedor=" + comedor +
                ", donante=" + donante +
                '}';
    }
}
