package com.webatrio.test.repository;

import com.webatrio.test.entity.Employment;
import com.webatrio.test.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Long> {
    List<Employment> findByCompanyName(String companyName);
    List<Employment> findByPersonAndStartDateBetween(Person person, LocalDate startDate, LocalDate endDate);
}