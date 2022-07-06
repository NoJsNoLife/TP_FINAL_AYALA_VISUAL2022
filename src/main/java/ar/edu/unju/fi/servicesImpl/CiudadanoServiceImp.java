package ar.edu.unju.fi.servicesImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.CiudadanoRepository;
import ar.edu.unju.fi.services.ICiudadanoService;

@Service
public class CiudadanoServiceImp implements ICiudadanoService {
	
	@Autowired
	private CiudadanoRepository ciudadanoRepo;
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoServiceImp.class);
	
	@Override
	public Ciudadano getCiudadano() {
		return new Ciudadano();
	}

	@Override
	public boolean saveCiudadano(Ciudadano ciudadano) {
		if(ciudadanoRepo.findByDni(ciudadano.getDni()) != null) {
			LOGGER.info("Ya existe un usuario con ese DNI registrado");
			return false;
		}
		try {
			if(ciudadanoRepo.save(ciudadano)!=null) {
				LOGGER.info("Se ha creado un nuevo ciudadano");
				return true;
			} else {
				LOGGER.info("Hubo un error al crear el nuevo ciudadano");
				return false;
			}
		} catch (Exception e) {
			LOGGER.info("Hubo un error al crear el nuevo ciudadano");
			return false;
		}
	}

	@Override
	public void setSesionIn(Ciudadano ciudadano) {
		if(ciudadano!=null) {
			ciudadano.setEstado(true);
			ciudadanoRepo.save(ciudadano);
			LOGGER.info("Se ha iniciado sesion para el DNI: "+ciudadano.getDni());
		}
	}

	@Override
	public void setSesionOut(Ciudadano ciudadano) {
		if(ciudadano!=null) {
			ciudadano.setEstado(false);
			ciudadanoRepo.save(ciudadano);
			LOGGER.info("Se ha cerrado sesion para el DNI: "+ciudadano.getDni());
		}
	}

	@Override
	public boolean modifyPerfilC(Ciudadano ciudadano) {
		Ciudadano c = ciudadanoRepo.findByEstado(true);
		if(c != null) {
			try {
				c.setNroT(ciudadano.getNroT());
				c.setEstadoC(ciudadano.getEstadoC());
				c.setProvincia(ciudadano.getProvincia());
				c.setTelefono(ciudadano.getTelefono());
				ciudadanoRepo.save(c);
				LOGGER.info("Se ha modificado el usuario con DNI: "+c.getDni());
				return true;
			} catch (Exception ex) {
				LOGGER.info("Hubo un error al modificar el usuario con DNI: "+c.getDni());
				return false;
			}
		}
		LOGGER.info("No se ha encontrado el ciudadano");
		return false;
	}

	@Override
	public void deleteCiudadano(int codigo) {
		try {
			if(ciudadanoRepo.deleteCiudadanoByCodigo(codigo)) {
				LOGGER.info("Se ha eliminado el ciudadano con el Codigo: "+codigo);
			} else {
				LOGGER.info("No se ha encontrado el ciudadano con el Codigo: "+codigo);
			}
		} catch (Exception e) {
			LOGGER.info("Hubo un error al eliminar el ciudadano con el Codigo: "+codigo);
		}
	}

	@Override
	public Ciudadano findByDniAndContrasenia(long dni, String contrasenia) {
		return ciudadanoRepo.findByDniAndContrasenia(dni, contrasenia);
	}

	@Override
	public Ciudadano findByEstado(boolean estado) {
		return ciudadanoRepo.findByEstado(estado);
	}

	@Override
	public Ciudadano findByDni(long dni) {
		return ciudadanoRepo.findByDni(dni);
	}


}
