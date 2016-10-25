package hu.uni.miskolc.iit.swtest.registrar.model;

public class Customer {

	private final long customerID;
	private final String name;
	private final Address address;

	public Customer(long customerID, String name, Address address) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.address = address;
	}

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

}
