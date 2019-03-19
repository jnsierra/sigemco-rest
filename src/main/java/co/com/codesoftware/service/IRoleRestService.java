package co.com.codesoftware.service;

import org.springframework.stereotype.Service;

import co.com.codesoftware.entity.RoleRestEntity;

@Service
public interface IRoleRestService {
	/**
	 * Metodo con el cual guardo un role rest 
	 * @param entity
	 * @return
	 */
	RoleRestEntity save(RoleRestEntity entity);
}
