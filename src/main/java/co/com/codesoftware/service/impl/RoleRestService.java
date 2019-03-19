package co.com.codesoftware.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.codesoftware.entity.RoleRestEntity;
import co.com.codesoftware.repository.IRoleRestRepository;
import co.com.codesoftware.service.IRoleRestService;

@Service
public class RoleRestService implements IRoleRestService {
	
	@Autowired
	IRoleRestRepository roleRestRepository;

	@Override
	public RoleRestEntity save(RoleRestEntity entity) {
		return roleRestRepository.save(entity);
	}

}