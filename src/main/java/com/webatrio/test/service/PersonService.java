package com.webatrio.test.service;

import com.webatrio.test.entity.Person;
import com.webatrio.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getAllPersonsOrderedByName() {
        return personRepository.findAllByOrderByLastNameAscFirstNameAsc();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {
        // Vérifier l'âge
        int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
        if (age >= 150) {
            throw new IllegalArgumentException("L'âge de la personne doit être inférieur à 150 ans.");
        }
        return personRepository.save(person);
    }

}
