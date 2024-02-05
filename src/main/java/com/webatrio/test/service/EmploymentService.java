package com.webatrio.test.service;

import com.webatrio.test.entity.Employment;
import com.webatrio.test.entity.Person;
import com.webatrio.test.repository.EmploymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EmploymentService {
    private final EmploymentRepository employmentRepository;

    public EmploymentService(EmploymentRepository employmentRepository) {
        this.employmentRepository = employmentRepository;
    }

    public Employment saveEmployment(Employment employment) {
        return employmentRepository.save(employment);
    }

    public List<Employment> getEmploymentsByCompanyName(String companyName) {
        return employmentRepository.findByCompanyName(companyName);
    }

    public List<Employment> getEmploymentsBetweenDates(Person person, LocalDate startDate, LocalDate endDate) {
        return employmentRepository.findByPersonAndStartDateBetween(person, startDate, endDate);
    }
}