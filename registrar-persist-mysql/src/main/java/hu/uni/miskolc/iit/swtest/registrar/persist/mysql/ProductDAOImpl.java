package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hu.uni.miskolc.iit.swtest.registrar.model.Category;
import hu.uni.miskolc.iit.swtest.registrar.model.Manufacturer;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.model.Size;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingProductException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ProductDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.ProductNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper.ProductMapper;

public class ProductDAOImpl implements ProductDAO {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private SqlSessionFactory sqlSessionFactory;
	
	public ProductDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
			throws FileNotFoundException {
		File configFile = new File(mybatisConfigPath);
		InputStream inputStream = new FileInputStream(configFile);
		String url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);
		Properties props = new Properties();
		props.put("driver", JDBC_DRIVER);
		props.put("url", url);
		props.put("username", user);
		props.put("password", password);
		this.sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
	}

	@Override
	public void createProduct(Product product) throws ExistingProductException {
		Collection<Product> similarProducts = readProductsByName(product.getName());
		if (!similarProducts.isEmpty())
			throw new ExistingProductException();
		SqlSession session = sqlSessionFactory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		productMapper.recordProduct("","","");
	}

	@Override
	public Collection<Product> readProducts() {
		Collection<Product> result = new ArrayList<Product>();
		SqlSession session = this.sqlSessionFactory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		result = productMapper.selectProducts();
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Product> readProductsByCategory(Category category) {
		Collection<Product> result = new ArrayList<Product>();
		SqlSession session = this.sqlSessionFactory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		result = productMapper.selectProductsByCategory(category);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Product> readProductsByName(String name) {
		Collection<Product> result = new ArrayList<Product>();
		SqlSession session = this.sqlSessionFactory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		result = productMapper.selectProductsByName(name);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Product> readProductsByManufacturer(Manufacturer manufacturer) {
		Collection<Product> result = new ArrayList<Product>();
		SqlSession session = this.sqlSessionFactory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		result = productMapper.selectProductsByManufactuter(manufacturer);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Product> readProductsBySize(Size size) {
		Collection<Product> result = new ArrayList<Product>();
		SqlSession session = this.sqlSessionFactory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		result = productMapper.selectProductsBySize(size);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Product readProduct(long productNumber) throws ProductNotFoundException {
		Product result = null;
		SqlSession session = this.sqlSessionFactory.openSession();
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		result = productMapper.selectProductById(productNumber);
		session.commit();
		session.close();
		if (result==null) {
			throw new ProductNotFoundException(String.format("There is no product with id<%d>", productNumber));
		}
		return result;
	}

	@Override
	public void updateProduct(Product product) throws ProductNotFoundException {
		SqlSession session = this.sqlSessionFactory.openSession();
		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.updateProduct(product);
		} catch (Exception e) {
			throw new ProductNotFoundException(e);
		}
		session.commit();
		session.close();
	}

	@Override
	public void deleteProduct(Product product) throws ProductNotFoundException {
		SqlSession session = this.sqlSessionFactory.openSession();
		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.deleteProduct(product);
		} catch (Exception e) {
			throw new ProductNotFoundException(e);
		}
		session.commit();
		session.close();
	}

}
