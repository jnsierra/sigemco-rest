package co.com.codesoftware.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.codesoftware.entity.PersonaEntity;
import co.com.codesoftware.repository.IPersonaRepository;
import co.com.codesoftware.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService {
	@Autowired
	IPersonaRepository personaRepository;

	@Override
	public PersonaEntity save(PersonaEntity persona) {
		return personaRepository.save(persona);
	}

}
