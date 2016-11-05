package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCustomerConstructorWithValidParameters() {
		new Customer(1, "Alex", new Address("X", "Y", "Z", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerConstructorWithInvalidCustomerID() {
		new Customer(0, "Alex", new Address("X", "Y", "Z", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerConstructorWithNullName() {
		new Customer(1, null, new Address("X", "Y", "Z", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerConstructorWithEmptyName() {
		new Customer(1, "", new Address("X", "Y", "Z", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerConstructorWithNullAddress() {
		new Customer(1, "Alex", null);
	}

	@Test
	public void testGetCustomerID() {
		Customer c = new Customer(1, "Alex", new Address("X", "Y", "Z", 1));
		assertEquals("customerID=1", 1, c.getCustomerID());
	}
	
	@Test
	public void testGetName() {
		Customer c = new Customer(1, "Alex", new Address("X", "Y", "Z", 1));
		assertEquals("name=Alex", "Alex", c.getName());
	}

	@Test
	public void testGetAddress() {
		Customer c = new Customer(1, "Alex", new Address("X", "Y", "Z", 1));
		assertEquals("address=(X,Y,Z,1)", new Address("X", "Y", "Z", 1), c.getAddress());
	}

	@Test
	public void testEqualsObject() {
		Customer c = new Customer(1, "Alex", new Address("X", "Y", "Z", 1));
		Customer d = new Customer(1, "Alex", new Address("X", "Y", "Z", 1));
		assertEquals("(1,Alex,(X,Y,Z,1))=(1,Alex,(X,Y,Z,1))", true, c.equals(d));
	}
	
	@Test
	public void testEqualsObjectWithDifferentCustomerID() {
		Customer c = new Customer(1, "Alex", new Address("X", "Y", "Z", 1));
		Customer d = new Customer(2, "Alex", new Address("X", "Y", "Z", 1));
		assertEquals("(1,Alex,(X,Y,Z,1))=(2,Alex,(X,Y,Z,1))", false, c.equals(d));
	}

}
