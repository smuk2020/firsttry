package com.shubhankar.countryCapital;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
class CountryController {

	private final CountryRepository repository;

	CountryController(CountryRepository repository) {
		this.repository = repository;
	}

	
	@GetMapping("/Countries")
	CollectionModel<EntityModel<Country>> all() {

		List<EntityModel<Country>> Countries = repository.findAll().stream()
				.map(Country -> EntityModel.of(Country,
						linkTo(methodOn(CountryController.class).one(Country.getCName())).withSelfRel(),
						linkTo(methodOn(CountryController.class).all()).withRel("Countries")))
				.collect(Collectors.toList());

		return CollectionModel.of(Countries, linkTo(methodOn(CountryController.class).all()).withSelfRel());
	}
	

	@PostMapping("/Countries")
	Country newCountry(@RequestBody Country newCountry) {
		return repository.save(newCountry);
	}

	
	@GetMapping("/Countries/{cName}")
	EntityModel<Country> one(@PathVariable String cName) {

		Country Country = repository.findById(cName) //
				.orElseThrow(() -> new CountryNotFoundException(cName));

		return EntityModel.of(Country, //
				linkTo(methodOn(CountryController.class).one(cName)).withSelfRel(),
				linkTo(methodOn(CountryController.class).all()).withRel("Countries"));
	}


	@PutMapping("/Countries/{cName}")
	Country replaceCountry(@RequestBody Country newCountry, @PathVariable String cName) {

		return repository.findById(cName) //
				.map(Country -> {
					Country.setCName(newCountry.getCName());
					Country.setCCap(newCountry.getCCap());
					return repository.save(Country);
				}) //
				.orElseGet(() -> {
					newCountry.setCName(cName);
					return repository.save(newCountry);
				});
	}

	@DeleteMapping("/Countries/{cName}")
	void deleteCountry(@PathVariable String cName) {
		repository.deleteById(cName);
	}
}