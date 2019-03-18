package co.com.codesoftware.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonInclude(Include.NON_NULL)
public class PersonaDto {
	
	private Long id;
	private String apellido;
	private String nombre;
	private String cedula;
	private String mail;
	private Date fechaNacimiento;
	private String telefono;
	private String cel;
	private String direccion;

}
