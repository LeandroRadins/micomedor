/**
 *
 */
package com.cordia.micomedor.micomedor.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Leandro
 *
 */

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
// #TODO: Hacer que el usuario este basado en roles y permisos. Ej: https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial
public abstract class Usuario {
    @Id
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    private Long id_usuario;

    @Column(name = "dni")
    private int dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    public Usuario() {
    }

    public Usuario(int dni, String nombre, String apellido, Date fechaNac, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.telefono = telefono;
    }
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getDni() == usuario.getDni() && getId_usuario().equals(usuario.getId_usuario()) && Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getApellido(), usuario.getApellido()) && Objects.equals(getFechaNac(), usuario.getFechaNac()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getTelefono(), usuario.getTelefono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_usuario(), getDni(), getNombre(), getApellido(), getFechaNac(), getEmail(), getTelefono());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNac=" + fechaNac +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
