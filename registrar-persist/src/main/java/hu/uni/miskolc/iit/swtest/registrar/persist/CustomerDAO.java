package hu.uni.miskolc.iit.swtest.registrar.persist;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.model.Customer;

public interface CustomerDAO {

	public void createCustomer(Customer customer) throws ExistingCustomerException;
	
	public Collection<Customer> readCustomers();
	public Collection<Customer> readCustomersByName(String name);
	public Collection<Customer> readCustomersByAddress(Address address);
	public Collection<Customer> readCustomersByCountry(String country);
	public Collection<Customer> readCustomersByCity(String country, String city) ;
	public Collection<Customer> readCustomersByStreet(String country, String city, String street);
	
	public Customer readCustomer(long customerID) throws CustomerNotFoundException;
	
	public void updateCustomer(Customer customer) throws CustomerNotFoundException;
	
	public void deleteCustomer(Customer customer) throws CustomerNotFoundException;
	
}
