package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ofertas")
@Component
public class Oferta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8516518150099619127L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ofe_codigo")
	private int codigo;
	@Column(name = "vacantes")
	@Min(value=1)
	private int vacantes = 1;
	@Column(name = "puesto")
	@NotBlank(message = "No puede estar vacio")
	private String puesto;
	@Column(name = "disponibilidad")
	@NotBlank(message = "No puede estar vacio")
	private String disponibilidad;
	@Column(name = "tareas")
	@NotBlank(message = "No puede estar vacio")
	private String tareas;
	@Column(name = "contacto")
	@NotBlank(message = "No puede estar vacio")
	private String contacto;
	@Column(name = "jornada")
	@NotBlank(message = "No puede estar vacio")
	private String jornada;
	@Column(name = "requisitos")
	@NotBlank(message = "No puede estar vacio")
	private String requisitos;
	@Column(name = "salario")
	@Min(value = 1, message = "Debe ser mayor a 0")
	private int salario;
	@Column(name = "beneficios")
	@NotBlank(message = "No puede estar vacio")
	private String beneficios;
	private boolean disponible = (vacantes > 0);
	public int getVacantes() {
		return vacantes;
	}
	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getTareas() {
		return tareas;
	}
	public void setTareas(String tareas) {
		this.tareas = tareas;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
}
