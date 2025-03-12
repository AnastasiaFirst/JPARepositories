package com.example.JPARepositories.controller;

import com.example.JPARepositories.entity.Person;
import com.example.JPARepositories.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam int age) {
        return personService.getPersonsYoungerThan(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
}