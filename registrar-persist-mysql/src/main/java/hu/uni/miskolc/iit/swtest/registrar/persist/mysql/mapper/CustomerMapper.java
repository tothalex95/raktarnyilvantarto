package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;
import hu.uni.miskolc.iit.swtest.registrar.model.Customer;

public interface CustomerMapper {

	public Collection<Customer> selectCustomers();
	
	public Collection<Customer> selectCustomersByName(@Param("name") String name);
	
	public Collection<Customer> selectCustomersByAddress(@Param("address") Address address);
	
	public Collection<Customer> selectCustomersByCountry(@Param("country") String country);
	
	public Collection<Customer> selectCustomersByCity(@Param("country") String country, @Param("city") String city);
	
	public Collection<Customer> selectCustomersByStreet(@Param("country") String country, @Param("city") String city, @Param("street") String street);
	
	public Customer selectCustomerByID(@Param("id") long id);
	
	public void updateCustomer(@Param("customer") Customer customer);
	
	public void deleteCustomer(@Param("customer") Customer customer);
	
	public void recordCustomer(@Param("name") String name, @Param("address") Address address);
	
}
