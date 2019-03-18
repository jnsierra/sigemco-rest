package co.com.codesoftware.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.codesoftware.entity.PersonaEntity;

@Repository
public interface IPersonaRepository extends CrudRepository<PersonaEntity, Long> {

}
