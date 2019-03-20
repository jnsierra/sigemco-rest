package co.com.codesoftware.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
	
	private Long id;
	private String usuario;
	private String contrasena;
	private PersonaDto persona;
	private Long sede;
	private List<RoleRestDto> rolesRest;
	
}