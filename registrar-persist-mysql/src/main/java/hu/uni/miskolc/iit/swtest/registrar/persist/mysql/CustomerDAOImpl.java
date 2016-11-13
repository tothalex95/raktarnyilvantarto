package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.model.Customer;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingCustomerException;

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
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Customer> readCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> readCustomersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> readCustomersByAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> readCustomersByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> readCustomersByCity(String country, String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> readCustomersByStreet(String country, String city, String street) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer readCustomer(long customerID) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub

	}

}
