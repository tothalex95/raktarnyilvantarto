package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithNullCountry() {
		new Address(null, "Y", "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithEmptyCountry() {
		new Address("", "Y", "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithNullCity() {
		new Address("X", null, "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithEmptyCity() {
		new Address("X", "", "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithNullStreet() {
		new Address("X", "Y", null, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithEmptyStreet() {
		new Address("X", "Y", "", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithIllegalNumber() {
		new Address("X", "Y", "Z", -1);
	}
	
	@Test
	public void testAddressConstructorWithValidParameters() {
		new Address("X", "Y", "Z", 1);
	}
	
	@Test
	public void testGetCountry() {
		Address a = new Address("X", "Y", "Z", 1);
		assertEquals("country=X", "X", a.getCountry());
	}
	
	@Test
	public void testGetCity() {
		Address a = new Address("X", "Y", "Z", 1);
		assertEquals("city=Y", "Y", a.getCity());
	}
	
	@Test
	public void testGetStreet() {
		Address a = new Address("X", "Y", "Z", 1);
		assertEquals("street=Z", "Z", a.getStreet());
	}
	
	@Test
	public void testGetNumber() {
		Address a = new Address("X", "Y", "Z", 1);
		assertEquals("number=1", 1, a.getNumber());
	}
	
	@Test
	public void testEqualsObject() {
		Address a = new Address("X", "Y", "Z", 1);
		Address b = new Address("X", "Y", "Z", 1);
		assertEquals("(X,Y,Z,1)=(X,Y,Z,1)", true, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentCountry() {
		Address a = new Address("X", "Y", "Z", 1);
		Address b = new Address("A", "Y", "Z", 1);
		assertEquals("(X,Y,Z,1)=(A,Y,Z,1)", false, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentCity() {
		Address a = new Address("X", "Y", "Z", 1);
		Address b = new Address("X", "A", "Z", 1);
		assertEquals("(X,Y,Z,1)=(X,A,Z,1)", false, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentStreet() {
		Address a = new Address("X", "Y", "Z", 1);
		Address b = new Address("X", "Y", "A", 1);
		assertEquals("(X,Y,Z,1)=(X,Y,A,1)", false, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentNumber() {
		Address a = new Address("X", "Y", "Z", 1);
		Address b = new Address("X", "Y", "Z", 2);
		assertEquals("(X,Y,Z,1)=(X,Y,Z,2)", false, a.equals(b));
	}

}
