package com.webatrio.test.controller;

import com.webatrio.test.entity.Person;
import com.webatrio.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PersonController {
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping(value = "/persons")
	public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersonsOrderedByName());
	}

	@PostMapping("/persons")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		Person savedPerson = personService.savePerson(person);
		return ResponseEntity.ok(savedPerson);
	}

}