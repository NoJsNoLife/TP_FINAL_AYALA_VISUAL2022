package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

//-----USUARIO----- LA EXISTENCIA DE ESTA CLASE CONTROLADORA IMPLICA QUE DEBEN HABER DOS LOGINS DISTINTOS: UNO PARA CIUDADANO Y OTRO PARA EMPLEADOR.

@Entity
@Table(name = "usuarios")
@Inheritance(strategy=InheritanceType.JOINED)
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
	@Column(name = "contraseña")
	@NotBlank(message = "No puede estar en blanco") @Size(min=8, max=12, message="Debe tener un minimo de 8 caracteres o un maximo de 12")
	private String contraseña;
	@Column(name = "provincia")
	@NotBlank(message = "No puede estar en blanco")
	private	String provincia;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	
	
}
