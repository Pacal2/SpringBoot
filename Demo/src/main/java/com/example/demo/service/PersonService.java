package com.example.demo.service;

import com.example.demo.dao.PersonDataAccessObject;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDataAccessObject personDataAccessObject;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDataAccessObject personDataAccessObject) {
        this.personDataAccessObject = personDataAccessObject;
    }

    public int addPerson(Person person) {
        return personDataAccessObject.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDataAccessObject.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDataAccessObject.selectPersonById(id);
    }

}
