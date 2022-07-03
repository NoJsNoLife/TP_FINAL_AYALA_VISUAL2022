package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Cvs")
@Component
public class Cv implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307033622333899128L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "codigo")
	private int codigo;
	@Column(name = "nombre")
	@NotBlank(message = "No puede estar vacio")
	private String nombre;
	@Column(name = "apellido")
	@NotBlank(message = "No puede estar vacio")
	private String apellido;
	@Column(name = "nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @Past(message = "La fecha no es correcta")
	private LocalDate fechaNacimiento;
	@Column(name = "dni")
	@NotBlank(message = "No puede estar vacio")
	private String dni;
	@Column(name = "contacto")
	@NotBlank(message = "No puede estar vacio")
	private String contacto;
	@Column(name = "educacion")
	@NotBlank(message = "No puede estar vacio")
	private String educacion;
	@Column(name = "idiomas")
	@NotBlank(message = "No puede estar vacio")
	private String idiomas;
	@Column(name = "conocimientosInf")
	@NotBlank(message = "No puede estar vacio")
	private String conocimientosInf;
	@Column(name = "experienciaLab")
	@NotBlank(message = "No puede estar vacio")
	private String experienciaLab;
	@Column(name = "datosAdicionales")
	@NotBlank(message = "No puede estar vacio")
	private String datosAdicionales;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getEducacion() {
		return educacion;
	}
	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	public String getConocimientosInf() {
		return conocimientosInf;
	}
	public void setConocimientosInf(String conocimientosInf) {
		this.conocimientosInf = conocimientosInf;
	}
	public String getExperienciaLab() {
		return experienciaLab;
	}
	public void setExperienciaLab(String experienciaLab) {
		this.experienciaLab = experienciaLab;
	}
	public String getDatosAdicionales() {
		return datosAdicionales;
	}
	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}
	
	
	
}
