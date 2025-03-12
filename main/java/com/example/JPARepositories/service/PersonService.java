package com.example.JPARepositories.service;

import com.example.JPARepositories.entity.Person;
import com.example.JPARepositories.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsYoungerThan(int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}