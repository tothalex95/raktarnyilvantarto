package hu.uni.miskolc.iit.swtest.registrar.persist.mysql;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import hu.uni.miskolc.iit.swtest.registrar.model.Product;
import hu.uni.miskolc.iit.swtest.registrar.persist.ProductDAO;

public class ProductDAOImplTest extends SetupDBTests {
	
	private ProductDAO dao;
	
	@Before
	public void setUp(){
		super.setUp();
		try {
			this.dao = new ProductDAOImpl(MYBATIS_CONFIG_FILE, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Assume.assumeNoException(e);
		}
	}

	

	@Test
	public void testCreateProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadProducts() {
		Collection<Product> actual =  dao.readProducts();
		for(Product product : actual){
			System.out.println("---------------------------> "+product);
		}
	}

	@Test
	public void testReadProductsByCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadProductsByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadProductsByManufacturer() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadProductsBySize() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
