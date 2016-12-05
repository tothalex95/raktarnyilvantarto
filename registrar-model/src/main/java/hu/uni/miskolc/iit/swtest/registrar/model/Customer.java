package hu.uni.miskolc.iit.swtest.registrar.model;

public class Customer {

	private final long customerID;
	private final String name;
	private final Address address;

	public Customer(Integer customerID, String name, Address address) {
		super();
		if (customerID < 1) throw new IllegalArgumentException("Customer ID must be positive.");
		else if (name == null || name.isEmpty()) throw new IllegalArgumentException("The name cannot be empty.");
		else if (address == null) throw new IllegalArgumentException("The address cannot be null.");
		this.customerID = customerID;
		this.name = name;
		this.address = address;
	}
	
	/*public Customer(Integer customerID, String name, Integer addressID, String country, String city, String street, Integer number) {
		this.customerID = customerID;
		this.name = name;
		this.address = new Address(addressID, country, city, street, number);
	}*/

	public long getCustomerID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerID ^ (customerID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}

}
