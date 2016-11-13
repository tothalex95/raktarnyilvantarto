package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.model.Customer;

public interface CustomerMapper {

	public Collection<Customer> selectCustomers();
	
	public Collection<Customer> selectCustomersByName(String name);
	
	public Collection<Customer> selectCustomersByAddress(Address address);
	
	public Collection<Customer> selectCustomersByCountry(String country);
	
	public Collection<Customer> selectCustomersByCity(String country, String city);
	
	public Collection<Customer> selectCustomersByStreet(String country, String city, String street);
	
	public Customer selectCustomerByID(long id);
	
	public void updateCustomer(@Param("customer") Customer customer);
	
	public void deleteCustomer(@Param("customer") Customer customer);
	
}
