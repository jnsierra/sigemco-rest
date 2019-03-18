package co.com.codesoftware.service;

import co.com.codesoftware.entity.PersonaEntity;

public interface IPersonaService {
	/**
	 * Metodo con el cual persisto una persona
	 * @param persona
	 * @return
	 */
	PersonaEntity save(PersonaEntity persona);
}
