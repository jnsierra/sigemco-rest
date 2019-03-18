package co.com.codesoftware.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.codesoftware.entity.ProductoEntity;
import co.com.codesoftware.repository.IProductoRepository;
import co.com.codesoftware.service.IProductoService;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	IProductoRepository productoRepository;

	@Override
	public List<ProductoEntity> findAll() {
		return productoRepository.findAllProductsByUser("A");
	}

}
