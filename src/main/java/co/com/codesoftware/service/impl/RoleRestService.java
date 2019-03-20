package co.com.codesoftware.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.codesoftware.entity.RoleRestEntity;
import co.com.codesoftware.entity.UsuarioEntity;
import co.com.codesoftware.repository.IRoleRestRepository;
import co.com.codesoftware.repository.IUsuarioRepository;
import co.com.codesoftware.service.IRoleRestService;

@Service
public class RoleRestService implements IRoleRestService {
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Autowired
	IRoleRestRepository roleRestRepository;

	@Override
	public RoleRestEntity save(RoleRestEntity entity) {
		return roleRestRepository.save(entity);
	}

	@Override
	public Optional<List<RoleRestEntity>> findRolesByUser(String usuario) {
		Optional<UsuarioEntity> userEntity = usuarioRepository.findByUsuario(usuario);
		if(userEntity.isPresent()) {
			return Optional.of(userEntity.get().getRolesRest());
		}else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> modifyRoleRestByUser(Long idUser, List<RoleRestEntity> idRoleRest) {
		if(!roleRestRepository.deleteRoleRestByUser(idUser)) {
			return Optional.of(Boolean.FALSE);
		}
		if(!roleRestRepository.saveRolesRestByUser(idUser, idRoleRest)) {
			return Optional.of(Boolean.FALSE);
		}
		return Optional.of(Boolean.TRUE);
	}

}