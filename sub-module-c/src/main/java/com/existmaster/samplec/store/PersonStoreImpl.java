package com.existmaster.samplec.store;

import com.existmaster.samplec.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by existmaster on 2016. 8. 16..
 */
@Repository
public class PersonStoreImpl implements PersonStore{

    @Autowired
    PersonRepository personRepository;

    public void create(Person person) {
        PersonDataObject p = personToDataObject(person);
        personRepository.save(p);
    }

    public Person read(String id) {
        PersonDataObject p = personRepository.findOne(id);
        return DataObjectToPerson(p);
    }

    private PersonDataObject personToDataObject(Person person){
        return new PersonDataObject(person.getId(), person.getName());
    }

    private Person DataObjectToPerson(PersonDataObject personDataObject) {
        return new Person(personDataObject.getId(), personDataObject.getName());
    }
}
