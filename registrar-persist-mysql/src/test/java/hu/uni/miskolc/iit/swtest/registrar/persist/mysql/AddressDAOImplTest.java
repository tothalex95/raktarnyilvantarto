package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.persist.AddressDAO;

public class AddressDAOImplTest extends SetupDBTests {

	private AddressDAO dao;

	@Before
	public void setUp() {
		super.setUp();
		try {
			dao = new AddressDAOImpl(MYBATIS_CONFIG_FILE, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Assume.assumeNoException(e);
		}
	}
	
	@Test
	public void testAddressDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAddresses() {
		Collection<Address> actual = dao.readAddresses();
		for (Address customer : actual)
			System.out.println("---------------------------> " + customer);
	}

	@Test
	public void testReadAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAddress() {
		fail("Not yet implemented");
	}

}
