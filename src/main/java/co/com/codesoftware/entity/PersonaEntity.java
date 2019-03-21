package co.com.codesoftware.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "us_tpers")
@Getter
@Setter
public class PersonaEntity extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
	@SequenceGenerator(name = "person_generator", sequenceName = "person_seq", allocationSize = 1)
	@Column(name = "pers_pers", updatable = false, nullable = false)
	private Long id;
	@Column(name = "pers_apellido")
	private String apellido;
	@NotNull
	@NotBlank
	@Column(name = "pers_nombre")
	private String nombre;
	@NotNull
	@NotBlank
	@Column(name = "pers_cedula", unique=true)
	private String cedula;
	@NotNull
	@NotBlank
	@Column(name = "pers_email", unique=true)
	private String mail;
	@Column(name = "pers_fecha_nac")
	private Date fechaNacimiento;
	@Column(name = "pers_tel")
	private String telefono;
	@Column(name = "pers_cel")
	private String cel;
	@Column(name = "pers_dir")
	private String direccion;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "persona")
	private UsuarioEntity usuario;

}
