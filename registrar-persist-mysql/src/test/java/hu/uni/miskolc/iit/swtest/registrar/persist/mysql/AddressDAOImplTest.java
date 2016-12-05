package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.persist.AddressDAO;
import hu.uni.miskolc.iit.swtest.registrar.persist.AddressNotFoundException;
import hu.uni.miskolc.iit.swtest.registrar.persist.ExistingAddressException;

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
	
	@Ignore
	@Test
	public void testAddressDAOImpl() {
		
	}

	@Test
	public void testCreateAddress() throws ExistingAddressException {
		dao.createAddress(new Address(4364, "HU", "MIskolc", "XY", 1));
	}

	@Test
	public void testReadAddresses() {
		Collection<Address> actual = dao.readAddresses();
		for (Address customer : actual)
			System.out.println("---------------------------> " + customer);
	}

	@Test
	public void testReadAddress() throws AddressNotFoundException {
		dao.readAddress(1);
	}

	@Test
	public void testUpdateAddress() throws AddressNotFoundException {
		dao.updateAddress(new Address(1, "HU", "Miskolc", "XY", 1));
	}

	@Test
	public void testDeleteAddress() throws AddressNotFoundException {
		dao.deleteAddress(new Address(1, "HU", "Miskolc", "sarok", 1));
	}

}
