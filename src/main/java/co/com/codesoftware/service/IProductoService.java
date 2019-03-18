package co.com.codesoftware.service;

import java.util.List;

import co.com.codesoftware.entity.ProductoEntity;

public interface IProductoService {
	/**
	 * Metodo con el cual busco todos los productos del sistema
	 * 
	 * @return
	 */
	public List<ProductoEntity> findAll();
}
