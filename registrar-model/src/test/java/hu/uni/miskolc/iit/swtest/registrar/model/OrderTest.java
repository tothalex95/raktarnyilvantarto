package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class OrderTest {
	
	@Test
	public void testOrderConstructorWithValidValues() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		lista.put(new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11)); 
		new Order(1, lista, cust);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOrderConstructorWithNegativeID() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		lista.put(new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11)); 
		new Order(-1, lista, cust);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOrderConstructorWithNullProducts() {
		Map<Product, Integer> lista = null;
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11)); 
		new Order(1, lista, cust);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOrderConstructorWithNullCustomer() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		lista.put(new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 10);
		Customer cust = null;
		new Order(1, lista, cust);
	}
	
	@Test
	public void testOrderAddWithValidValues() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		lista.put(new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		order.add(new Product(2, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOrderAddWithInvalidProduct() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		lista.put(new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		order.add(null, 10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOrderAddWithInvalidNumber() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		lista.put(new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, 
				Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		order.add(butter, -3);
		//order.add(new Product(2, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))),1);
	}
	
	@Test
	public void testOrderRemoveWithValidValues() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		order.remove(termek, 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOrderRemoveWithInvalidProduct() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product masiktermek = new Product(2, Category.FURNITURE, "Másik", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		order.remove(masiktermek, 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOrderRemoveWithInvalidNumber() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		order.remove(termek, 33);
	}
	
	@Test
	public void testOrderRemoveProductWithValidValues() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		order.remove(termek);
	}
	
	@Test
	public void testGetID() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		assertEquals("orderID=1", 1, order.getOrderID());
	}
	
	@Test
	public void testGetProducts() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product masiktermek = new Product(2, Category.FURNITURE, "Másik", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		lista.put(masiktermek, 12);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		assertEquals(lista, order.getProducts());
	}
	
	@Test
	public void testGetCustomer() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 500, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		assertEquals(new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11)), order.getCustomer());
	}
	
	@Test
	public void testGetWeight() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product masiktermek = new Product(2, Category.FURNITURE, "Másik", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		lista.put(masiktermek, 12);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		float ret = 0;
		for (Product p : order.getProducts().keySet()) {
			ret += p.getWeight() * order.getProducts().get(p);
		}
		assertEquals(true, Float.floatToIntBits(220) == Float.floatToIntBits(order.getWeight()));
	}
	
	@Test
	public void testEquals() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		Order order2 = new Order(1, lista, cust);
		assertEquals(true, order.equals(order2));
	}
	
	@Test
	public void testEqualsWithSelf() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		assertEquals(true, order.equals(order));
	}
	
	@Test
	public void testEqualsWithNull() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		assertEquals(false, order.equals(null));
	}
	
	@Test
	public void testEqualsWithDifferentClass() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		assertEquals(false, order.equals("string"));
	}
	
	@Test
	public void testEqualsWithDifferentOrderID() {
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		Order order2 = new Order(2, lista, cust);
		assertEquals(false, order.equals(order2));
	}
	
	@Test
	public void testToString(){
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		assertEquals("Order [orderID=1, products={Product [productNumber=1, category=Food, name=Mittomén, manufacturer=APPLE, size=Size [width=10, height=10, depth=10], weight=10.0, restriction=0]=10}, customer=Customer [customerID=1, name=Teszt, address=Address [country=Hun, city=Miskolc, street=Egyetemváros, number=11]]]" , order.toString());
	}
	
	@Test
	public void testHashCode(){
		Map<Product, Integer> lista = new HashMap<Product, Integer>();
		Product termek = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		lista.put(termek, 10);
		Customer cust = new Customer(1, "Teszt", new Address("Hun", "Miskolc", "Egyetemváros", 11));
		Order order = new Order(1, lista, cust);
		Order order2 = new Order(1, lista, cust);
		assertTrue(order.hashCode() == order2.hashCode());
	}
}