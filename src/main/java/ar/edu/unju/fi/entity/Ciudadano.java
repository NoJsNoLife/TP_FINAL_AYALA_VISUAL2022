package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@PrimaryKeyJoinColumn(name="usu_codigo")
@Component
public class Ciudadano implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6553898866157297477L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ciu_codigo")
	private int codigo;
	@Column(name = "nroTramite")
	@Min(value=1, message = "Debe ser minimo 1")
	@Max(value=999999, message = "Debe ser maximo 999.999")
	private int nroT;
	@Column(name = "estado")
	private String estado;
	@Column(name = "nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @Past(message = "La fecha no es correcta")
	private LocalDate fechaNacimiento;
	
	//-----CIUDADANO A CV----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE TENER UN TIPO CV
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Cv cv;
	
	
	
	//-----CIUDADANO A OFERTAS----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE TENER VARIAS OFERTAS A LAS QUE SE POSTULE GUARDADAS EN UNA LISTA
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Oferta> ofertas;
	
	public Ciudadano() {
	}
	
	public int getNroT() {
		return nroT;
	}
	public void setNroT(int nroT) {
		this.nroT = nroT;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Cv getCv() {
		return cv;
	}
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
}
