/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao.impl;

import bluejnr.beans.Person;
import bluejnr.dao.PersonDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kcuadror
 */
public class PersonDaoMemory implements PersonDao{

    private List<Person> persons;

    public PersonDaoMemory() {
        persons = new ArrayList<>();
    }

    @Override
    public void create(Person t) {
        if (find(t.getDocumentNumber()) == null) {
            persons.add(t);
        }
    }

    @Override
    public void update(Person t) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getDocumentNumber().equals(t.getDocumentNumber())) {
                persons.set(i, t);
                break;
            }
        }
    }

    @Override
    public void delete(String v) {
        persons.remove(find(v));
    }

    @Override
    public Person find(String v) {
        for(Person person:persons){
            if(person.getDocumentNumber().equals(v))
                return person;
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }

}
