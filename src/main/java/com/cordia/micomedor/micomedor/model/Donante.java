package com.cordia.micomedor.micomedor.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "DONANTE")
public class Donante extends Usuario {

    // Relaciones
    // Un donante hace muchas donaciones
    @OneToMany(mappedBy = "donante")
    private Set<Donacion> donaciones = new HashSet<>();

    public Donante() {
    }

    public Donante(Set<Donacion> donaciones) {
        this.donaciones = donaciones;
    }

    public Set<Donacion> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(Set<Donacion> donaciones) {
        this.donaciones = donaciones;
    }
}
