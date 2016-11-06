package hu.uni.miskolc.iit.swtest.registrar.model;

public class Address {

	private final String country;
	private final String city;
	private final String street;
	private final int number;

	public Address(String country, String city, String street, int number) {
		super();
		if (country == null || country.isEmpty()) throw new IllegalArgumentException("The country cannot be empty.");
		else if (city == null || city.isEmpty()) throw new IllegalArgumentException("The city cannot be empty.");
		else if (street == null || street.isEmpty()) throw new IllegalArgumentException("The street cannot be empty.");
		else if (number < 1) throw new IllegalArgumentException("The number must be positive.");
		this.country = country;
		this.city = city;
		this.street = street;
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + city.hashCode();
		result = prime * result + country.hashCode();
		result = prime * result + number;
		result = prime * result + street.hashCode();
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
		Address other = (Address) obj;
		if (!city.equals(other.city))
			return false;
		if (!country.equals(other.country))
			return false;
		if (number != other.number)
			return false;
		if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street=" + street + ", number=" + number + "]";
	}
	

}
