package co.com.codesoftware.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.codesoftware.dto.RoleRestDto;
import co.com.codesoftware.dto.error.ResponseRestService;
import co.com.codesoftware.entity.RoleRestEntity;
import co.com.codesoftware.service.IRoleRestService;

@RestController
@RequestMapping("/v.1/rolerest")
public class RoleRestController {

	@Autowired
	ModelMapper map;

	@Autowired
	IRoleRestService roleRestService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<ResponseRestService<RoleRestDto>> save(@RequestBody RoleRestDto roleRestDto) {
		return new ResponseEntity<>(
				new ResponseRestService<>(
						map.map(roleRestService.save(map.map(roleRestDto, RoleRestEntity.class)), RoleRestDto.class)),
				HttpStatus.CREATED);
	}
}
