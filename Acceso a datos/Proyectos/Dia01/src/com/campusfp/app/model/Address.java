package com.campusfp.app.model;

public class Address {
	//	Attributes
	private String	street;
	private int		nr;
	private String	zip;
	

	//	Constructors
	public Address(String street, int nr, String zip) {
		this.street = street;
		this.nr = nr;
		this.zip = zip;
	}

	//	Methods
	@Override
	public String toString() {
		return "Address [nr=" + nr + ", street=" + street + ", zip=" + zip + "]";
	}

	//	Getters and setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
