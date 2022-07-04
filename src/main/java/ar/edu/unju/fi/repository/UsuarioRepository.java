package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.email = ?1 and u.contrasenia = ?2")
	public Usuario findByEmailAndContrasenia(String email, String contrasenia);
	
	public List<Usuario> findAll();
	
	@Query("delete from Usuario u where u.codigo = ?1")
	public boolean deleteUsuarioByCodigo(int codigo);
	
	@Query("select u from Usuario u where u.email = ?1")
	public Usuario findByEmail(String email);
	
	public Usuario findByCodigo(int codigo);
	
	@Query("select u from Usuario u where u.estado = ?1")
	public Usuario findByEstado(boolean estado);
}
