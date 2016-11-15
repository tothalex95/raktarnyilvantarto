package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Category;
import hu.uni.miskolc.iit.swtest.registrar.model.Manufacturer;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.model.Size;

public interface ProductMapper {

	public Collection<Product> selectProducts();
	
	public Collection<Product> selectProductsByCategory(Category category);
	
	public Collection<Product> selectProductsByName(String name);
	
	public Collection<Product> selectProductsByManufactuter(Manufacturer manufacturer);
	
	public Collection<Product> selectProductsBySize(Size size);
	
	public Product selectProductById(long id);
	
	public void updateProduct(@Param("product") Product product);
	
	public void deleteProduct(@Param("product") Product product);
	
	public void recordProduct();
	
}
