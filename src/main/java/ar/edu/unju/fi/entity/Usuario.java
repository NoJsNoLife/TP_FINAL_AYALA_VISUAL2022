package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

//-----USUARIO----- LA EXISTENCIA DE ESTA CLASE CONTROLADORA IMPLICA QUE DEBEN HABER DOS LOGINS DISTINTOS: UNO PARA CIUDADANO Y OTRO PARA EMPLEADOR.

@Entity
@Table(name = "usuarios")
@Component
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3373989659425507614L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "usu_codigo")
	private int codigo;
	@Column(name = "email")
	@Email(message = "Ingrese un email valido") @NotBlank(message = "Ingrese un email valido")
	private String email;
	@Column(name = "contrasenia")
	@NotBlank(message = "Ingrese una contraseña valida") @Size(min=8, max=12, message="Debe tener un minimo de 8 caracteres o un maximo de 12")
	private String contrasenia;
	@Column(name = "provincia")
	private	String provincia;
	@Column(name = "tipo")
	private	String tipo;
	@Column(name = "estado")
	private boolean estado = true;
	
	//-----EMPLEADOR A USUARIO----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE PERTENECER A UN SOLO TIPO EMPLEADOR
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private Empleador empleador;
	
	//-----CIUDADANO A USUARIO----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE PERTENECER A UN SOLO TIPO CIUDADANO
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private Ciudadano ciudadano;
	
	
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Empleador getEmpleador() {
		return empleador;
	}
	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	
}
