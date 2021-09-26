package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Leandro
 */
@Entity
@Table(name = "comedores")
public class Comedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comedores")
    @SequenceGenerator(name = "seq_comedores", allocationSize = 1)
    @Column(name = "id_comedor")
    private Long id_comedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    // Relaciones
    
    // Un comedor puede tener uno o mas representantes
    @OneToMany(mappedBy = "comedor")
    private Set<Representante> representantes = new HashSet<>();

    // Un comedor puede tener muchas donaciones
    @OneToMany(mappedBy = "comedor")
    private Set<Donacion> donaciones = new HashSet<>();

    // Un comedor tiene especificamente 365 jornadas, donde cada jornada representa un dia
    @OneToMany(mappedBy = "comedor")
    private Set<Jornada> jornadas = new HashSet<>();

    // Un comedor puede tener muchos comensales inscriptos
    @OneToMany(mappedBy = "comedor")
    private Set<Comensal> comensales = new HashSet<>();

    public Comedor() {

    }

    public Comedor(Comedor comedor) {
        //TODO: Hacer el copy constructor para el "faker"
        this.nombre = comedor.getNombre();
        this.direccion = comedor.getDireccion();
        this.correo = comedor.getCorreo();
        this.telefono = comedor.getTelefono();
    }

    public Comedor(String nombre, String direccion, String correo, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Long getId_comedor() {
        return id_comedor;
    }

    public void setId_comedor(Long id_comedor) {
        this.id_comedor = id_comedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Representante> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(Set<Representante> representantes) {
        this.representantes = representantes;
    }

    public Set<Donacion> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(Set<Donacion> donaciones) {
        this.donaciones = donaciones;
    }

    public Set<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(Set<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    public Set<Comensal> getComensales() {
        return comensales;
    }

    public void setComensales(Set<Comensal> comensales) {
        this.comensales = comensales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comedor comedor = (Comedor) o;
        return getId_comedor().equals(comedor.getId_comedor()) && Objects.equals(getNombre(), comedor.getNombre()) && Objects.equals(getDireccion(), comedor.getDireccion()) && Objects.equals(getCorreo(), comedor.getCorreo()) && Objects.equals(getTelefono(), comedor.getTelefono()) && Objects.equals(getRepresentantes(), comedor.getRepresentantes()) && Objects.equals(getDonaciones(), comedor.getDonaciones()) && Objects.equals(getJornadas(), comedor.getJornadas()) && Objects.equals(getComensales(), comedor.getComensales());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_comedor(), getNombre(), getDireccion(), getCorreo(), getTelefono(), getRepresentantes(), getDonaciones(), getJornadas(), getComensales());
    }

    @Override
    public String toString() {
        return "Comedor{" +
                "id_comedor=" + id_comedor +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", representantes=" + representantes +
                ", donaciones=" + donaciones +
                ", jornadas=" + jornadas +
                ", comensales=" + comensales +
                '}';
    }
}
