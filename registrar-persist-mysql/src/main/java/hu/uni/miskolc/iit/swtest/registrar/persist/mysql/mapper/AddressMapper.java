package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;

public interface AddressMapper {

	public Collection<Address> selectAddresses();

	/*public Collection<Address> selectAddressesByCountry(@Param("country") String country);

	public Collection<Address> selectAddressesByCity(@Param("city") String city);

	public Collection<Address> selectAddressesByStreet(@Param("street") String street);

	public Address selectAddress(@Param("country") String country, @Param("city") String city, @Param("street") String street, @Param("num") Integer num);*/

	public Address selectAddress(@Param("id") Integer id);
	
	public void recordAddress(@Param("id") Integer id, @Param("country") String country, @Param("city") String city, @Param("street") String street, @Param("number") Integer number);
	
	public void updateAddress(@Param("address") Address address);
	
	public void deleteAddress(@Param("address") Address address);
	
}
