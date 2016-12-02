package hu.uni.miskolc.iit.swtest.registrar.model;

public class Address {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer id;
	private final String country;
	private final String city;
	private final String street;
	private final int number;

	public Address(Integer id, String country, String city, String street, Integer number) {
		super();
		this.id = id;
		if (country == null || country.isEmpty())
			throw new IllegalArgumentException("The country cannot be empty.");
		else if (city == null || city.isEmpty())
			throw new IllegalArgumentException("The city cannot be empty.");
		else if (street == null || street.isEmpty())
			throw new IllegalArgumentException("The street cannot be empty.");
		else if (number < 1)
			throw new IllegalArgumentException("The number must be positive.");
		this.country = country;
		this.city = city;
		this.street = street;
		this.number = number;
	}

	public Address(String address) {
		String[] tmp = address.split(":");
		if (tmp[0] == null || tmp[0].isEmpty())
			throw new IllegalArgumentException("The country cannot be empty.");
		else if (tmp[1] == null || tmp[1].isEmpty())
			throw new IllegalArgumentException("The city cannot be empty.");
		else if (tmp[2] == null || tmp[2].isEmpty())
			throw new IllegalArgumentException("The street cannot be empty.");
		else if (Integer.parseInt(tmp[3]) < 1)
			throw new IllegalArgumentException("The number must be positive.");
		this.country = tmp[0];
		this.city = tmp[1];
		this.street = tmp[2];
		this.number = Integer.parseInt(tmp[3]);
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
