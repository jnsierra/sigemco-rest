package co.com.codesoftware.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="in_tprpr")
@Getter
@Setter
public class PrecioProductoEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="prpr_prpr")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prpr_dska", nullable = false)
	private ProductoEntity producto;
	@Column(name="prpr_estado")
	private String estado;
	@Column(name="prpr_sede")
	private Long sede;
	
}
