/**
 *
 */
package com.cordia.micomedor.micomedor.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * @author Leandro
 *
 */
@Entity
@DiscriminatorValue(value = "REPRESENTANTE")
public class Representante extends Usuario {

    // Relaciones
    // Un Representante forma parte de un solo comedor
    @ManyToOne
    @JoinColumn(name = "id_comedor_rep")
    private Comedor comedor;

    public Representante() {

    }

    public Representante(Comedor comedor) {
        this.comedor = comedor;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Representante)) return false;
        if (!super.equals(o)) return false;
        Representante that = (Representante) o;
        return Objects.equals(getComedor(), that.getComedor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getComedor());
    }

    @Override
    public String toString() {
        return "Representante{" +
                "comedor=" + comedor +
                '}';
    }
}
