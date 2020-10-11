/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.pruebas;

import bluejnr.beans.LegalPerson;
import bluejnr.beans.NaturalPerson;
import bluejnr.beans.Person;
import bluejnr.service.PersonService;
import bluejnr.service.impl.PersonServiceImpl;
import bluejnr.util.Document;
import static bluejnr.util.Document.DNI;
import static bluejnr.util.Document.RUC;

/**
 *
 * @author kcuadror
 */
public class Prueba03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        Person person1 = new LegalPerson("Tienda01", RUC, "1234567890", "address01", "email01@gmai.com", "123456789");
        Person person2 = new NaturalPerson("Paterno01", "Materno01", "Name01", DNI, "12345678", "address03", "email02@gmai.com", "765347987");
        Person person3 = new LegalPerson("Tienda02", RUC, "0987654321", "address02", "email02@gmai.com", "987654321");
        personService.create(person1);
        personService.create(person2);
        personService.create(person3);

        System.out.println("Lista de Personas");
        personService.findAll().stream().forEach((person) -> {
            System.out.println(person);
        });

        System.out.println("Buscar Persona con dni 12345678: " + personService.find("12345678"));
        person2.setAddress("address10");
        personService.update(person2);
        personService.delete("0987654321");

        System.out.println("Lista de Personas actual");
        personService.findAll().stream().forEach((person) -> {
            System.out.println(person);
        });
    }
    
}
