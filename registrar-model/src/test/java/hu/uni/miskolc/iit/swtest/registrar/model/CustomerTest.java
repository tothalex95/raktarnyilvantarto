package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import java.util.EnumSet;

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

	@Test
	public void testToString(){
		Customer c = new Customer(1, "Adam", new Address("X", "Y", "Z", 1));
		assertTrue(c.toString().equals("Customer [customerID=1, name=Adam, address=Address [country=X, city=Y, street=Z, number=1]]"));
	}
	
	@Test
	public void testHashCode(){
		Customer c = new Customer(1, "Adam", new Address("X", "Y", "Z", 1));
		Customer b = new Customer(1, "Adam", new Address("X", "Y", "Z", 1));
		assertTrue(c.hashCode()==b.hashCode());
	}
	
	@Test
	public void testEqualsObjectWithNull(){
		Customer b = new Customer(1, "Adam", new Address("X", "Y", "Z", 1));
		assertFalse(b.equals(null));
	}
	
	@Test
	public void testEqualObjectWithItSelf(){
		Customer b = new Customer(1, "Adam", new Address("X", "Y", "Z", 1));
		assertTrue(b.equals(b));
	}
	@Test
	public void testEqualsObjectWithDiffernetObject(){
		Customer b = new Customer(1, "Adam", new Address("X", "Y", "Z", 1));
		assertEquals(false, b.equals("string"));
	}
}

