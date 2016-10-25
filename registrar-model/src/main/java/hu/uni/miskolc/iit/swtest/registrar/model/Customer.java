package hu.uni.miskolc.iit.swtest.registrar.model;

public class Customer {

	private final long customerID;
	private final Order order;
	private final String name;
	
	public Customer(long customerID, Order order, String name) {
		super();
		this.customerID = customerID;
		this.order = order;
		this.name = name;
	}

	public long getCustomerID() {
		return customerID;
	}
	
	public Order getOrder() {
		return order;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", order=" + order + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerID ^ (customerID >>> 32));
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	
}
