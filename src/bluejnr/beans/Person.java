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
public class Person {

    private String name;
    private Document document;
    private String documentNumber; 
    private String address;
    private String email;
    private String telephone;

    public Person() {
    }

    public Person(String name, Document document, String documentNumber, String address, String email, String telephone) {
        this.name = name;
        this.document = document;
        this.documentNumber = documentNumber;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", document=" + document + ", documentNumber=" + documentNumber + ", address=" + address + ", email=" + email + ", telephone=" + telephone + '}';
    }

}
