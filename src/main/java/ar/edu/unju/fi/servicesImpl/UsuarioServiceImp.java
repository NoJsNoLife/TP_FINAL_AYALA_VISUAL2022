package ar.edu.unju.fi.servicesImpl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controllers.UsuarioController;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.UsuarioRepository;
import ar.edu.unju.fi.services.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);

	@Override
	public Usuario getUsuario() {
		return new Usuario();
	}

	@Override
	public boolean saveUsuario(Usuario usuario) {
		if(usuarioRepo.findByEmail(usuario.getEmail()) != null) {
			LOGGER.info("Ya existe un usuario con ese email registrado");
			return false;
		}
		try {
			if(usuarioRepo.save(usuario)!=null) {
				LOGGER.info("Se ha creado un nuevo usuario");
				return true;
			} else {
				LOGGER.info("Hubo un error al crear el nuevo usuario");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al crear el nuevo usuario");
			return false;
		}
	}

	@Override
	public boolean modifyUsuario(Usuario usuario) {
		Usuario u = usuarioRepo.findByEmailAndContrasenia(usuario.getEmail(), usuario.getContrasenia());
		if(u != null) {
			try {
				u.setEmail(usuario.getEmail());
				u.setContrasenia(usuario.getContrasenia());
				u.setEstado(usuario.isEstado());
				LOGGER.info("Se ha modificado el usuario con Codigo: "+u.getCodigo());
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				LOGGER.info("Hubo un error al modificar el usuario con Codigo: "+usuario.getCodigo());
				return false;
			}
		}
		LOGGER.info("No se ha encontrado el usuario con Codigo: "+usuario.getCodigo());
		return false;
	}

	@Override
	public void deleteUsuario(int codigo) {
		try {
			if(usuarioRepo.deleteUsuarioByCodigo(codigo)) {
				LOGGER.info("Se ha eliminado el usuario con codigo: "+codigo);
			} else {
				LOGGER.info("No se ha encontrado el usuario con codigo: "+codigo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al eliminar el usuario con codigo: "+codigo);
		}
	}

	@Override
	public Usuario findByEmailAndContrasenia(String email, String contrasenia) {
		return usuarioRepo.findByEmailAndContrasenia(email, contrasenia);
	}

	@Override
	public Usuario findByEmail(String email) {
		return usuarioRepo.findByEmail(email);
	}

	@Override
	public void setSesionIn(String email, String contrasenia) {
		Usuario u = usuarioRepo.findByEmailAndContrasenia(email, contrasenia);
		if(u!= null) {
			u.setEstado(true);
			LOGGER.info("Se ha iniciado sesion para el email: "+email);
		}
	}

	@Override
	public void setSesionOut(String email, String contrasenia) {
		Usuario u = usuarioRepo.findByEmailAndContrasenia(email, contrasenia);
		if(u!= null) {
			u.setEstado(false);
			LOGGER.info("Se ha cerrado sesion para el email: "+email);
		}
	}

	@Override
	public Usuario findByCodigo(int codigo) {
		return usuarioRepo.findByCodigo(codigo);
	}

	@Override
	public Usuario findByEstado(boolean estado) {
		return usuarioRepo.findByEstado(estado);
	}

}
