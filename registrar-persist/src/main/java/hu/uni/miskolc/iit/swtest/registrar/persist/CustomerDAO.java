package hu.uni.miskolc.iit.swtest.registrar.persist;

import java.util.List;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.model.Customer;

public interface CustomerDAO {

	public void createCustomer(Customer customer) throws ExistingCustomerException;
	
	public List<Customer> readCustomers();
	public List<Customer> readCustomersByName(String name);
	public List<Customer> readCustomersByAddress(Address address);
	public List<Customer> readCustomersByCountry(String country);
	public List<Customer> readCustomersByCity(String country, String city) ;
	public List<Customer> readCustomersByStreet(String country, String city, String street);
	
	public Customer readCustomer(int customerID) throws CustomerNotFoundException;
	
	public void updateCustomer(Customer customer) throws CustomerNotFoundException;
	
	public void deleteCustomer(Customer customer) throws CustomerNotFoundException;
	
}
