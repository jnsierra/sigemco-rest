package co.com.codesoftware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.codesoftware.entity.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long>, CrudRepository<UsuarioEntity, Long> {
	/**
	 * Metodo con el cual obtengo todos los usuarios parametrizados en el sistema
	 * @return
	 */
	List<UsuarioEntity> getAll();
}