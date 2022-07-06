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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Ciudadano implements Serializable{

	/**DNI, EMAIL, CONTRASEÑA, PROVINCIA Y FECHA DE NACIMIENTO
	 * 
	 */
	private static final long serialVersionUID = -6553898866157297477L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ciu_codigo")
	private int codigo;
	@Column(name = "dni")
	private long dni;
	@Column(name = "email")
	@Email(message = "Ingrese un email valido") @NotBlank(message = "Ingrese un email valido")
	private String email;
	@Column(name = "contrasenia")
	@NotBlank(message = "Ingrese una contraseña valida") @Size(min=8, max=12, message="Debe tener un minimo de 8 caracteres o un maximo de 12")
	private String contrasenia;
	@Column(name = "provincia")
	private	String provincia;
	@Column(name = "estado")
	private boolean estado = true;
	@Column(name = "telefono")
	private int telefono;
	@Column(name = "estadocivil")
	private String estadoC;
	@Column(name = "nroTramite")
	private int nroT;
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
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEstadoC() {
		return estadoC;
	}

	public void setEstadoC(String estadoC) {
		this.estadoC = estadoC;
	}
	
	
	
}
