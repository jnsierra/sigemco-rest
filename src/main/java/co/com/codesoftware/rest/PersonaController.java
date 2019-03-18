package co.com.codesoftware.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.codesoftware.dto.PersonaDto;
import co.com.codesoftware.entity.PersonaEntity;
import co.com.codesoftware.service.IPersonaService;

@RestController
@RequestMapping("/v.1/persona")
public class PersonaController {
	@Autowired
	IPersonaService personaService;
	
	@Autowired
	ModelMapper map;
	
	@RequestMapping(method=RequestMethod.POST, value="/")
	public ResponseEntity<PersonaEntity> save(@RequestBody PersonaDto personaDto){
		return new ResponseEntity<>(personaService.save(map.map(personaDto, PersonaEntity.class)), HttpStatus.CREATED);
	}
}
