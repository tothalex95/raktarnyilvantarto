package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
