/**
 * 
 */
package com.cordia.micomedor.micomedor.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	/**
	 * @return the id_usuario
	 */
	public Long getId_usuario() {
		return id_usuario;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return the fechaNac
	 */
	public Date getFechaNac() {
		return fechaNac;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, email, fechaNac, id_usuario, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni && Objects.equals(email, other.email)
				&& Objects.equals(fechaNac, other.fechaNac) && Objects.equals(id_usuario, other.id_usuario)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id_usuario=");
		builder.append(id_usuario);
		builder.append(", dni=");
		builder.append(dni);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", fechaNac=");
		builder.append(fechaNac);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append("]");
		return builder.toString();
	}

}
