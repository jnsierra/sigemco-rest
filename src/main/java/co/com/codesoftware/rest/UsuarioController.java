package co.com.codesoftware.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.codesoftware.dto.UsuarioDto;
import co.com.codesoftware.entity.UsuarioEntity;
import co.com.codesoftware.service.IUsuarioService;

@RestController
@RequestMapping("/v.1/usuario")
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	ModelMapper map;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usuario) {
		return new ResponseEntity<UsuarioDto>(
				map.map(usuarioService.save(map.map(usuario, UsuarioEntity.class)), UsuarioDto.class),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<UsuarioDto[]> getAll() {
		return new ResponseEntity<UsuarioDto[]>(map.map(usuarioService.getAll(), UsuarioDto[].class), HttpStatus.OK);
	}

}
