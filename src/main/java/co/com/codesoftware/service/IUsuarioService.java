package co.com.codesoftware.service;

import java.util.List;

import co.com.codesoftware.entity.UsuarioEntity;

public interface IUsuarioService {
	/**
	 * Metodo con el cual guardamos un usuario en el sistema
	 * @return
	 */
	UsuarioEntity save(UsuarioEntity usuario);
	/**
	 * Metodo con el cual obtengo todos los usuarios
	 * @return
	 */
	List<UsuarioEntity> getAll();

}
