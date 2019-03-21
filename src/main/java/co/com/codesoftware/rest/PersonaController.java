package co.com.codesoftware.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.codesoftware.dto.PersonaDto;
import co.com.codesoftware.dto.error.ResponseRestService;
import co.com.codesoftware.entity.PersonaEntity;
import co.com.codesoftware.service.IPersonaService;

@RestController
@RequestMapping("/v.1/persona")
public class PersonaController {
	@Autowired
	IPersonaService personaService;
	
	@Autowired
	ModelMapper mapper;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(method=RequestMethod.POST, value="/")
	public ResponseEntity< ResponseRestService< PersonaDto > > save(@RequestBody PersonaDto personaDto){
		return new ResponseEntity<>(
				new ResponseRestService<>(mapper.map(personaService.save(mapper.map(personaDto, PersonaEntity.class)), PersonaDto.class))
				, HttpStatus.CREATED);
	}
	
}
