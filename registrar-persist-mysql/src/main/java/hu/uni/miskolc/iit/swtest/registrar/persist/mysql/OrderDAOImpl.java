package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hu.uni.miskolc.iit.swtest.registrar.model.Customer;
import hu.uni.miskolc.iit.swtest.registrar.model.Order;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerDiscrepancyException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingOrderException;
import hu.uni.miskolc.iit.swtest.registrar.persist.OrderDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.OrderNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ProductNotFoundException;

public class OrderDAOImpl implements OrderDAO {

private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
    private SqlSessionFactory sqlSessionFactory;

    public OrderDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
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
	public void createOrder(Order order) throws ExistingOrderException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Order> readOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Order> readOrdersByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Order> readOrdersByProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Order> readOrdersByProductsMap(Map<Product, Integer> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order readOrder(long orderID) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Order order) throws OrderNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void mergeOrder(Order base, Order additional) throws OrderNotFoundException, CustomerDiscrepancyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProductToOrder(Order order, Product product, int toadd)
			throws OrderNotFoundException, ProductNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProductFromOrder(Order order, Product product, int toremove)
			throws OrderNotFoundException, ProductNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProductFromOrder(Order order, Product product)
			throws OrderNotFoundException, ProductNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(Order order) throws OrderNotFoundException {
		// TODO Auto-generated method stub

	}

}
