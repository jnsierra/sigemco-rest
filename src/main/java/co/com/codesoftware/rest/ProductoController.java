package co.com.codesoftware.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.codesoftware.dto.ProductoDto;
import co.com.codesoftware.entity.ProductoEntity;
import co.com.codesoftware.service.IProductoService;

@RestController
@RequestMapping("/v.1/product")
public class ProductoController {
	
	@Autowired
	IProductoService productoService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/")
	public ResponseEntity<ProductoDto[]> getProductos(){
		List<ProductoEntity> aux = productoService.findAll();
		for(ProductoEntity item : aux ) {
			System.out.println("Id: " + item.getNombre());
		}
		return new ResponseEntity<>(modelMapper.map(aux, ProductoDto[].class),HttpStatus.OK);
	}
	
}
