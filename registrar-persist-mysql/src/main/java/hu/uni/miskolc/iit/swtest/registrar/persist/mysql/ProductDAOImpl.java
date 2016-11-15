package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.registrar.model.Category;
import hu.uni.miskolc.iit.swtest.registrar.model.Manufacturer;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.model.Size;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingProductException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ProductDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.ProductNotFoundException;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void createProduct(Product product) throws ExistingProductException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Product> readProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Product> readProductsByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Product> readProductsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Product> readProductsByManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Product> readProductsBySize(Size size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product readProduct(long productNumber) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deleteProduct(Product product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
