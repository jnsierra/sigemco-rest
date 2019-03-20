package co.com.codesoftware.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.codesoftware.entity.RoleRestEntity;
import co.com.codesoftware.repository.IRoleRestRepositoryCustom;

@Repository
@Transactional
public class IRoleRestRepositoryImpl implements IRoleRestRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Boolean deleteRoleRestByUser(Long id) {
		Query query = entityManager.createNativeQuery("DELETE FROM usuario_rolerest WHERE tius_tius = ? ");
		query.setParameter(1, id);
		query.executeUpdate();
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveRolesRestByUser(Long idUser, List<RoleRestEntity> idRolesRest) {
		for(RoleRestEntity item : idRolesRest) {
			Query query = entityManager.createNativeQuery("insert into usuario_rolerest ( tius_tius, rore_rore ) values (?,?)");
			query.setParameter(1, idUser);
			query.setParameter(2, item.getId());
			query.executeUpdate();
			
		}
		return Boolean.TRUE;
	}

}
