/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.beans;

import bluejnr.util.Document;

/**
 *
 * @author kcuadror
 */
public class LegalPerson extends Person{

    public LegalPerson() {
    }

    public LegalPerson(String name, Document document, String documentNumber, String address, String email, String telephone) {
        super(name, document, documentNumber, address, email, telephone);
    }

    @Override
    public String toString() {
        return "LegalPerson{" + '}'
                + super.toString();
    }
    
    
}
