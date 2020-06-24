package com.shubhankar.countryCapital;

@SuppressWarnings("serial")
class CountryNotFoundException extends RuntimeException {

	CountryNotFoundException(String cName) {
		super("Invalid Country Name!!! " + cName);
	}
}