package com.webatrio.test.controller;

import com.webatrio.test.entity.Employment;
import com.webatrio.test.entity.Person;
import com.webatrio.test.service.EmploymentService;
import com.webatrio.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v2", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmploymentController {
	private final PersonService personService;
	private final EmploymentService employmentService;


	@Autowired
	public EmploymentController(PersonService personService, EmploymentService employmentService) {
		this.personService = personService;
		this.employmentService= employmentService;
	}


	@PostMapping("/employments")
	public ResponseEntity<Employment> saveEmployment(@RequestBody Employment employment) {
		Employment savedEmployment = employmentService.saveEmployment(employment);
		return ResponseEntity.ok(savedEmployment);
	}

	@GetMapping("employments/{companyName}")
	public ResponseEntity<List<Employment>> getEmploymentsByPerson(@PathVariable String companyName) {

			List<Employment> employments = employmentService.getEmploymentsByCompanyName(companyName);
			return ResponseEntity.ok(employments);
	}

	@GetMapping("employments-between-dates/ByPerson/{id}")
	public ResponseEntity<List<Employment>> getEmploymentsBetweenDates(
			@PathVariable Long id,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

		Optional<Person> person = personService.findById(id);

		if (person.isPresent()) {
			List<Employment> employments = employmentService.getEmploymentsBetweenDates(person.get(), startDate, endDate);
			return ResponseEntity.ok(employments);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}