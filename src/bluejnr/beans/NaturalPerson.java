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
public class NaturalPerson  extends Person{
    
    private String fatherSurName;
    private String motherSurName;

    public NaturalPerson(String fatherSurName, String motherSurName) {
        this.fatherSurName = fatherSurName;
        this.motherSurName = motherSurName;
    }

    public NaturalPerson(String fatherSurName, String motherSurName, String name, Document document, String documentNumber, String address, String email, String telephone) {
        super(name, document, documentNumber, address, email, telephone);
        this.fatherSurName = fatherSurName;
        this.motherSurName = motherSurName;
    }
    
    public String getFatherSurName() {
        return fatherSurName;
    }

    public void setFatherSurName(String fatherSurName) {
        this.fatherSurName = fatherSurName;
    }

    public String getMotherSurName() {
        return motherSurName;
    }

    public void setMotherSurName(String motherSurName) {
        this.motherSurName = motherSurName;
    }

    @Override
    public String toString() {
        return "NaturalPerson{" + "fatherSurName=" + fatherSurName + ", motherSurName=" + motherSurName + '}'
                + super.toString();
    }
    
    
}
