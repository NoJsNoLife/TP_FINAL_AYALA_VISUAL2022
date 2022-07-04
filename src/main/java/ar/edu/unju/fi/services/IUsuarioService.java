package ar.edu.unju.fi.services;



import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {
	public Usuario getUsuario();
	public boolean saveUsuario(Usuario usuario);
	public void setSesionIn(String email, String contrasenia);
	public void setSesionOut(String email, String contrasenia);
	public boolean modifyUsuario(Usuario usuario);
	public void deleteUsuario(int codigo);
	public Usuario findByEmailAndContrasenia(String email, String contrasenia);
	public Usuario findByEmail(String email);
	public Usuario findByCodigo(int codigo);
	public Usuario findByEstado(boolean estado);
}
