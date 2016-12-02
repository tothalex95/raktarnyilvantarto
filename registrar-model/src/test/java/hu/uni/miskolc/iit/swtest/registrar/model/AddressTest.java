package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithNullCountry() {
		new Address(0, null, "Y", "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithEmptyCountry() {
		new Address(0, "", "Y", "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithNullCity() {
		new Address(0, "X", null, "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithEmptyCity() {
		new Address(0, "X", "", "Z", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithNullStreet() {
		new Address(0, "X", "Y", null, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithEmptyStreet() {
		new Address(0, "X", "Y", "", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddressConstructorWithIllegalNumber() {
		new Address(0, "X", "Y", "Z", -1);
	}
	
	@Test
	public void testAddressConstructorWithValidParameters() {
		new Address(0, "X", "Y", "Z", 1);
	}
	
	@Test
	public void testGetCountry() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertEquals("country=X", "X", a.getCountry());
	}
	
	@Test
	public void testGetCity() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertEquals("city=Y", "Y", a.getCity());
	}
	
	@Test
	public void testGetStreet() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertEquals("street=Z", "Z", a.getStreet());
	}
	
	@Test
	public void testGetNumber() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertEquals("number=1", 1, a.getNumber());
	}
	
	@Test
	public void testEqualsObject() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		Address b = new Address(0, "X", "Y", "Z", 1);
		assertEquals("(X,Y,Z,1)=(X,Y,Z,1)", true, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentCountry() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		Address b = new Address(0, "A", "Y", "Z", 1);
		assertEquals("(X,Y,Z,1)=(A,Y,Z,1)", false, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentCity() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		Address b = new Address(0, "X", "A", "Z", 1);
		assertEquals("(X,Y,Z,1)=(X,A,Z,1)", false, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentStreet() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		Address b = new Address(0, "X", "Y", "A", 1);
		assertEquals("(X,Y,Z,1)=(X,Y,A,1)", false, a.equals(b));
	}
	
	@Test
	public void testEqualsObjectWithDifferentNumber() {
		Address a = new Address(0, "X", "Y", "Z", 1);
		Address b = new Address(0, "X", "Y", "Z", 2);
		assertEquals("(X,Y,Z,1)=(X,Y,Z,2)", false, a.equals(b));
	}
	
	@Test
	public void testHashCode(){
		Address a = new Address(0, "X", "Y", "Z", 1);
		Address b = new Address(0, "X", "Y", "Z", 1);
		assertTrue(a.hashCode()==b.hashCode());
	}
	
	@Test
	public void testEqualObjectWithItSelf(){
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertTrue(a.equals(a));
	}
	
	@Test
	public void testEqualsObjectWithNull(){
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertFalse(a.equals(null));
	}
	
	@Test
	public void testEqualsObjectWithDiffernetObject(){
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertFalse(a.equals("asd"));
	}
	
	@Test
	public void testToString(){
		Address a = new Address(0, "X", "Y", "Z", 1);
		assertTrue(a.toString().equals("Address [country=X, city=Y, street=Z, number=1]"));
	}

}
