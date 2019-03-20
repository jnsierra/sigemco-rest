package co.com.codesoftware.repository;

import java.util.List;

import co.com.codesoftware.entity.RoleRestEntity;

public interface IRoleRestRepositoryCustom {
	/**
	 * Metodo con el cual se elimino todos los roles rest de un usuario
	 * @return
	 */
	Boolean deleteRoleRestByUser(Long id);
	/**
	 * Metodo con el cual le agrego al usuario roles rest para tener acceso a los servicios restfull
	 * @param idUser
	 * @param idRolesRest
	 * @return
	 */
	Boolean saveRolesRestByUser(Long idUser, List<RoleRestEntity> idRolesRest );

}
