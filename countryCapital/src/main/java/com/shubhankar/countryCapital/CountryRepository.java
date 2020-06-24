package com.shubhankar.countryCapital;
import org.springframework.data.jpa.repository.JpaRepository;

interface CountryRepository extends JpaRepository<Country, String> {

}