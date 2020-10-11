/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.service.impl;

import bluejnr.beans.Person;
import bluejnr.beans.Person;
import bluejnr.dao.PersonDao;
import bluejnr.dao.impl.DaoFactory;
import bluejnr.service.PersonService;
import static bluejnr.util.Util.opc;
import java.util.List;

/**
 *
 * @author kcuadror
 */
public class PersonServiceImpl implements PersonService{

    private PersonDao dao;

    public PersonServiceImpl() {
        DaoFactory factory = DaoFactory.getInstance();
        dao = factory.getPersonDao(opc);
    }
    
    @Override
    public void create(Person t) {
        dao.create(t);
    }

    @Override
    public void update(Person t) {
        dao.update(t);
    }

    @Override
    public void delete(String v) {
        dao.delete(v);
    }

    @Override
    public Person find(String v) {
        return dao.find(v);
    }

    @Override
    public List<Person> findAll() {
        return dao.findAll();
    }
    
}
