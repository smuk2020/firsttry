package com.shubhankar.countryCapital;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Country {

	
	private @Id String cName;
	private String cCap;

	Country() {}

	Country(String cName, String cCap) {

		this.cName = cName;
		this.cCap = cCap;
	}

	

	public String getCName() {
		return this.cName;
	}

	public String getCCap() {
		return this.cCap;
	}

	

	public void setCName(String cName) {
		this.cName = cName;
	}

	public void setCCap(String cCap) {
		this.cCap = cCap;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Country))
			return false;
		Country country = (Country) o;
		return Objects.equals(this.cName, country.cName)
				&& Objects.equals(this.cCap, country.cCap);
	}

	@Override
	public int hashCode() {
		return Objects.hash( this.cName, this.cCap);
	}

	@Override
	public String toString() {
		return "Country{" + ", CName='" + this.cName + '\'' + ", CCap='" + this.cCap + '\'' + '}';
	}
}