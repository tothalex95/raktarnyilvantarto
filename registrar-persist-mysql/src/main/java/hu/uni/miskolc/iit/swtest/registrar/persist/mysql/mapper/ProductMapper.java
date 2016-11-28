package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Category;
import hu.uni.miskolc.iit.swtest.registrar.model.Manufacturer;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.model.Size;

public interface ProductMapper {

	public Collection<Product> selectProducts();

	public Collection<Product> selectProductsByCategory(@Param("category") Category category);

	public Collection<Product> selectProductsByName(@Param("name") String name);

	public Collection<Product> selectProductsByManufactuter(@Param("manufacturer") Manufacturer manufacturer);

	public Collection<Product> selectProductsBySize(@Param("size") Size size);

	public Product selectProductById(@Param("id") long id);

	public void updateProduct(@Param("product") Product product);

	public void deleteProduct(@Param("product") Product product);

	public void recordProduct(@Param("category") String category, @Param("name") String name,
			@Param("manufacturer") String manufacturer, @Param("size") Size size, @Param("weight") float weight,
			@Param("restriction") int restriction);

}
