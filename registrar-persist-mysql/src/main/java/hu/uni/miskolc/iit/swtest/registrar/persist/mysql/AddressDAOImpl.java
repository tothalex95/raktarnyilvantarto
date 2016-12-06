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
import hu.uni.miskolc.iit.swtest.registrar.persist.AddressDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.AddressNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingAddressException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingCustomerException;
import hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper.AddressMapper;
import hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper.CustomerMapper;

public class AddressDAOImpl implements AddressDAO {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private SqlSessionFactory sqlSessionFactory;

	public AddressDAOImpl(String mybatisConfigPath, String host, int port, String database, String user,
			String password) throws FileNotFoundException {
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
	public void createAddress(Address address) throws ExistingAddressException {
		SqlSession session = sqlSessionFactory.openSession();
		AddressMapper addressMapper = session.getMapper(AddressMapper.class);
		addressMapper.recordAddress(address.getId(), address.getCountry(), address.getCity(), address.getStreet(), address.getNumber());
		session.commit();
		session.close();
	}

	@Override
	public Collection<Address> readAddresses() {
		Collection<Address> result = new ArrayList<Address>();
		SqlSession session = sqlSessionFactory.openSession();
		AddressMapper customerMapper = session.getMapper(AddressMapper.class);
		result = customerMapper.selectAddresses();
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Address readAddress(Integer id) throws AddressNotFoundException {
		Address result = null;
		SqlSession session = sqlSessionFactory.openSession();
		AddressMapper customerMapper = session.getMapper(AddressMapper.class);
		result = customerMapper.selectAddress(id);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public void updateAddress(Address address) throws AddressNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			AddressMapper mapper = session.getMapper(AddressMapper.class);
			mapper.updateAddress(address);
		} catch (Exception e) {
			throw new AddressNotFoundException();
		}
		session.commit();
		session.close();
	}

	@Override
	public void deleteAddress(Address address) throws AddressNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			AddressMapper mapper = session.getMapper(AddressMapper.class);
			mapper.deleteAddress(address);
		} catch (Exception e) {
			throw new AddressNotFoundException();
		}
		session.commit();
		session.close();
	}

	@Override
	public Collection<Address> readAddressesByCountry(String country) {
		Collection<Address> result = new ArrayList<Address>();
		SqlSession session = sqlSessionFactory.openSession();
		AddressMapper customerMapper = session.getMapper(AddressMapper.class);
		result = customerMapper.selectAddressesByCountry(country);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Collection<Address> readAddressesByCity(String city) {
		Collection<Address> result = new ArrayList<Address>();
		SqlSession session = sqlSessionFactory.openSession();
		AddressMapper customerMapper = session.getMapper(AddressMapper.class);
		result = customerMapper.selectAddressesByCity(city);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Address readAddressByAddress(String country, String city, String street, Integer number) {
		Address result = null;
		SqlSession session = sqlSessionFactory.openSession();
		AddressMapper customerMapper = session.getMapper(AddressMapper.class);
		result = customerMapper.selectAddressByAddress(country, city, street, number);
		session.commit();
		session.close();
		return result;
	}

}
