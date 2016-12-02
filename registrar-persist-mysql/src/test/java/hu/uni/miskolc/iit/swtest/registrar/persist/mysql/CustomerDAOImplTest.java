package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.uni.miskolc.iit.swtest.registrar.model.Customer;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.CustomerNotFoundException;

public class CustomerDAOImplTest extends SetupDBTests {

	private CustomerDAO dao;

	@Before
	public void setUp() {
		super.setUp();
		try {
			dao = new CustomerDAOImpl(MYBATIS_CONFIG_FILE, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Assume.assumeNoException(e);
		}
	}

	@Test
	public void testCustomerDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateCustomer() {
		fail("Not yet implemented");
	}

	//@Ignore
	@Test
	public void testReadCustomers() {
		Collection<Customer> actual = dao.readCustomers();
		for (Customer customer : actual)
			System.out.println("---------------------------> " + customer);
	}

	@Test
	public void testReadCustomersByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCustomersByAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCustomersByCountry() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCustomersByCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCustomersByStreet() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCustomer() throws CustomerNotFoundException {
		Customer actual = dao.readCustomer(2);
		System.out.println("----------------------- " + actual);
	}

	@Test
	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

}
