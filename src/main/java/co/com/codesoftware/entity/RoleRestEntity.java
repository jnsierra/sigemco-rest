package co.com.codesoftware.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="us_trore")
@Getter @Setter
public class RoleRestEntity extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolerest_generator")
	@SequenceGenerator(name = "rolerest_generator", sequenceName = "rolerest_seq", allocationSize = 1)
	@Column(name="rore_rore")
	private Long id;
	@NotNull(message="El nombre del role no puede ser nulo")
	@Column(name="rore_nombre", unique=true)
	private String nombre;
	@ManyToMany(mappedBy = "rolesRest")
	private List<UsuarioEntity> usuarios = new ArrayList<>();
	
	public RoleRestEntity() {
	}
	
	public RoleRestEntity(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleRestEntity other = (RoleRestEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}	
	
}