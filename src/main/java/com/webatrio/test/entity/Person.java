package com.webatrio.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<Employment> employments;

   /* @JsonProperty("employments")
    public List<Employment> getNonRecursiveEmployments() {
        // Retournez une copie de la liste pour éviter la boucle infinie
        return new ArrayList<>(employments);
    }*/

}