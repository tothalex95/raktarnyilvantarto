package hu.uni.miskolc.iit.swtest.registrar.persist;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.registrar.model.Address;

public interface AddressDAO {

	public void createAddress(Address address) throws ExistingAddressException;

	public Collection<Address> readAddresses();

	public Address readAddress(Integer id) throws AddressNotFoundException;

	public void updateAddress(Address address) throws AddressNotFoundException;

	public void deleteAddress(Address address) throws AddressNotFoundException;

}
