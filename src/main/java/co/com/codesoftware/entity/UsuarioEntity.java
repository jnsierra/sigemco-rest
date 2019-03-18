package co.com.codesoftware.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="us_ttius")
@NamedQueries({
	@NamedQuery(name="UsuarioEntity.getAll", query = "select usuarioEntity from UsuarioEntity usuarioEntity inner join usuarioEntity.persona persona ")
})
@Getter @Setter
public class UsuarioEntity extends Auditable<String> {
	@Id
	@Column(name="tius_tius", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
	@SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_seq", allocationSize = 1)
	private Long id;
	@Column(name="tius_usuario")
	private String usuario;
	@Column(name="tius_contra_act")
	private String contrasena;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tius_pers", nullable = false)
	private PersonaEntity persona;
	@Column(name="tius_sede")
	private Long sede;
	
}
