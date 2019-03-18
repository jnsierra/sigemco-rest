package co.com.codesoftware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.codesoftware.entity.ProductoEntity;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Long>, CrudRepository<ProductoEntity, Long>{
	
	List<ProductoEntity> findAllProductsByUser(@Param("estado") String estado);

}
