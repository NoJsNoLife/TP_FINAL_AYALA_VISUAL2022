package ar.edu.unju.fi.services;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoService {
	public Ciudadano getCiudadano();
	public boolean saveCiudadano(Ciudadano ciudadano);
	public void setSesionIn(Ciudadano ciudadano);
	public void setSesionOut(Ciudadano ciudadano);
	public boolean modifyPerfilC(Ciudadano ciudadano);
	public void deleteCiudadano(int codigo);
	public Ciudadano findByDniAndContrasenia(long dni, String contrasenia);
	public Ciudadano findByEstado(boolean estado);
	public Ciudadano findByDni(long dni);
}
