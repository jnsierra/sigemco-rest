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
	/**
	 * Metodo con el cual se valida si las credenciales de un usuario son correctas
	 * @param usuario
	 * @param contra
	 * @return
	 */
	Boolean validateAuth(String usuario, String contra);

}
