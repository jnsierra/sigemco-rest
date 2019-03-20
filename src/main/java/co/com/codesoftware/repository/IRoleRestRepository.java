package co.com.codesoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.codesoftware.entity.RoleRestEntity;

@Repository
public interface IRoleRestRepository extends JpaRepository<RoleRestEntity, Long>, CrudRepository<RoleRestEntity, Long>, IRoleRestRepositoryCustom{

}