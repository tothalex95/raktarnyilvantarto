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

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.model.Customer;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingCustomerException;
import hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper.CustomerMapper;

public class CustomerDAOImpl implements CustomerDAO {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
    private SqlSessionFactory sqlSessionFactory;

    public CustomerDAOImpl(String mybatisConfigPath, String host, int port, String database, String user, String password)
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
	public void createCustomer(Customer customer) throws ExistingCustomerException {
		Collection<Customer> similarCustomers = readCustomersByName(customer.getName());
		if (!similarCustomers.isEmpty())
			throw new ExistingCustomerException();
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		Address a = customer.getAddress();
		customerMapper.recordCustomer(customer.getName(), String.join(":", a.getCountry(), a.getCity(), a.getStreet(), String.valueOf(a.getNumber())));
		session.commit();
		session.close();
	}

	@Override
	public Collection<Customer> readCustomers() {
		Collection<Customer> result = new ArrayList<Customer>();
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		result = customerMapper.selectCustomers();
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Customer> readCustomersByName(String name) {
		Collection<Customer> result = new ArrayList<Customer>();
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		result = customerMapper.selectCustomersByName("%" + name + "%");
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Customer> readCustomersByAddress(Address address) {
		Collection<Customer> result = new ArrayList<Customer>();
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		result = customerMapper.selectCustomersByAddress(address);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Customer> readCustomersByCountry(String country) {
		Collection<Customer> result = new ArrayList<Customer>();
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		result = customerMapper.selectCustomersByCountry(country);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Customer> readCustomersByCity(String country, String city) {
		Collection<Customer> result = new ArrayList<Customer>();
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		result = customerMapper.selectCustomersByCity(country, city);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Customer> readCustomersByStreet(String country, String city, String street) {
		Collection<Customer> result = new ArrayList<Customer>();
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		result = customerMapper.selectCustomersByStreet(country, city, street);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Customer readCustomer(long customerID) throws CustomerNotFoundException {
		Customer result = null;
		SqlSession session = sqlSessionFactory.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		result = customerMapper.selectCustomerByID(customerID);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CustomerMapper mapper = session.getMapper(CustomerMapper.class);
			mapper.updateCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException(e);
		}
		session.commit();
		session.close();
	}

	@Override
	public void deleteCustomer(Customer customer) throws CustomerNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CustomerMapper mapper = session.getMapper(CustomerMapper.class);
			mapper.deleteCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException(e);
		}
		session.commit();
		session.close();
	}

}
