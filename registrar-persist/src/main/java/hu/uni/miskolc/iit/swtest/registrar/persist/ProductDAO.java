package hu.uni.miskolc.iit.swtest.registrar.persist;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.registrar.model.Category;
import hu.uni.miskolc.iit.swtest.registrar.model.Manufacturer;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.model.Size;

public interface ProductDAO {

	public void createProduct(Product product) throws ExistingProductException;
	
	public Collection<Product> readProducts();
	public Collection<Product> readProductsByCategory(Category category);
	public Collection<Product> readProductsByName(String name);
	public Collection<Product> readProductsByManufacturer(Manufacturer manufacturer);
	public Collection<Product> readProductsBySize(Size size);
	
	public Product readProduct(long productNumber) throws ProductNotFoundException;
	
	public Product updateProduct(Product product) throws ProductNotFoundException;
	
	public Product deleteProduct(Product product) throws ProductNotFoundException;
	
	
	

	
}
