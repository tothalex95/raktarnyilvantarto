package hu.uni.miskolc.iit.swtest.registrar.persist;

import java.util.Collection;
import java.util.Map;

import hu.uni.miskolc.iit.swtest.registrar.model.Customer;
import hu.uni.miskolc.iit.swtest.registrar.model.Order;
import hu.uni.miskolc.iit.swtest.registrar.model.Product;

public interface OrderDAO {

	public void createOrder(Order order) throws ExistingOrderException;
	
	public Collection<Order> readOrders();
	public Collection<Order> readOrdersByCustomer(Customer customer);
	public Collection<Order> readOrdersByProduct(Product product);
	public Collection<Order> readOrdersByProductsMap(Map<Product, Integer> products);
	
	public Order readOrder(long orderID) throws OrderNotFoundException;
	
	public void updateOrder(Order order) throws OrderNotFoundException;
	public void mergeOrder(Order base, Order additional) throws OrderNotFoundException, CustomerDiscrepancy;
	public void addProductToOrder(Order order, Product product, int toadd) throws OrderNotFoundException, ProductNotFoundException;
	public void removeProductFromOrder(Order order, Product product, int toremove) throws OrderNotFoundException, ProductNotFoundException;
	public void removeProductFromOrder(Order order, Product product) throws OrderNotFoundException, ProductNotFoundException;
	
	public void deleteOrder(Order order) throws OrderNotFoundException;
	
	
}
