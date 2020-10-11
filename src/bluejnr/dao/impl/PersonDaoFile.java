/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao.impl;

import bluejnr.beans.LegalPerson;
import bluejnr.beans.NaturalPerson;
import bluejnr.beans.Person;
import bluejnr.dao.PersonDao;
import bluejnr.util.Document;
import static bluejnr.util.Document.DNI;
import static bluejnr.util.Document.RUC;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

/**
 *
 * @author kcuadror
 */
public class PersonDaoFile implements PersonDao {

    private List<Person> persons;

    public PersonDaoFile() {
        persons = new ArrayList<>();
        //readPersons();
    }

    @Override
    public void create(Person t) {
        if (find(t.getDocumentNumber()) == null) {
            persons.add(t);
            savePersons();
        }
    }

    @Override
    public void update(Person t) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getDocumentNumber().equals(t.getDocumentNumber())) {
                persons.set(i, t);
                savePersons();
                break;
            }
        }
    }

    @Override
    public void delete(String v) {
        persons.remove(find(v));
        savePersons();
    }

    @Override
    public Person find(String v) {
        readPersons();
        for (Person person : persons) {
            if (person.getDocumentNumber().equals(v)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        readPersons();
        return persons;
    }

    private void savePersons() {
        String linea;
        try (BufferedWriter bufOutput = new BufferedWriter(new FileWriter("persons.txt"))) {
            for (Person person : persons) {
                linea = person.getName() + ","
                        + person.getDocument() + ","
                        + person.getDocumentNumber() + ","
                        + person.getAddress() + ","
                        + person.getEmail() + ","
                        + person.getTelephone();
                bufOutput.write(linea);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("[grabar] Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo grabar persons.txt: " + e);
        }
    }

    private void readPersons() {
        try (BufferedReader bufInput = new BufferedReader(new FileReader("persons.txt"))) {
            String linea;
            persons.clear();
            Person person;
            while ((linea = bufInput.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                person = new Person();
                person.setName(tokens.nextToken().trim());
                person.setDocument(Document.valueOf(tokens.nextToken().trim()));
                person.setDocumentNumber(tokens.nextToken().trim());
                person.setAddress(tokens.nextToken().trim());
                person.setEmail(tokens.nextToken().trim());
                person.setTelephone(tokens.nextToken().trim());
                persons.add(person);


            }
        } catch (FileNotFoundException f) {
            System.out.println("[leer]Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo leer persons.txt: " + e);
        }
    }
}
