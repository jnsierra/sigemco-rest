package co.com.codesoftware.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "in_tdska")
@NamedQueries({
		@NamedQuery(name = "ProductoEntity.findAllProductsByUser", query = "select productoEntity from ProductoEntity productoEntity inner join productoEntity.precio precioProd where precioProd.estado = :estado ") })
@Getter
@Setter
public class ProductoEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "dska_dska")
	private Long id;
	@Column(name = "dska_nom_prod")
	private String nombre;
	@Column(name = "dska_cod_ext")
	private String codigoExterno;
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<PrecioProductoEntity> precio;

	public ProductoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoEntity(Long id, String nombre, String codigoExterno, List<PrecioProductoEntity> precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigoExterno = codigoExterno;
		this.precio = precio;
	}

}
