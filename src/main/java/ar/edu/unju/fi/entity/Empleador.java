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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@PrimaryKeyJoinColumn(name="usu_codigo")
@Component
public class Empleador extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383147667958120938L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "emp_codigo")
	private int codigo;
	@Column(name = "cuit")
	@Size(min=10, max=10, message = "Debe tener 10 cifras sin guiones")
	private String cuit;
	@Column(name = "razon")
	@NotBlank(message = "No puede estar vacio")
	private String razon;
	@Column(name = "nombre")
	@NotBlank(message = "No puede estar vacio")
	private String nombre;
	@Column(name = "inicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @PastOrPresent(message = "La fecha no es correcta")
	private LocalDate fechaInicio;
	@Column(name = "domicilio")
	@NotBlank(message = "No puede estar vacio")
	private String domicilio;
	@Column(name = "pagina")
	private String pagina;
	@Column(name = "descripcion")
	@NotBlank(message = "No puede estar vacio")
	private String descripcion;
	
	//-----EMPLEADOR A USUARIO----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE PERTENECER A UN SOLO TIPO EMPLEADOR
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	//-----EMPLEADOR A OFERTA----- IMPLICA QUE EL TIPO EMPLEADOR PUEDE PUBLICAR UNA O MAS OFERTAS Y GUARDARLAS EN UNA LISTA
	@OneToMany(fetch = FetchType.LAZY)
	private List<Oferta> ofertas;
	
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	
	
}
