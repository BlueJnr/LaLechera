/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao.impl;

import bluejnr.dao.OrderDao;
import bluejnr.dao.PersonDao;
import bluejnr.dao.ProductDao;
import static bluejnr.util.Util.FILE;
import static bluejnr.util.Util.MEMORY;

/**
 *
 * @author kcuadror
 */
public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public OrderDao getOrderDao(int tipo) {
        switch (tipo) {
            case MEMORY: return new OrderDaoMemory();
            case FILE: return new OrderDaoFile();
            default: return null;
        }
    }
    
    public PersonDao getPersonDao(int tipo) {
        switch (tipo) {
            case MEMORY: return new PersonDaoMemory();
            case FILE: return new PersonDaoFile();
            default: return null;
        }
    }
    
    public ProductDao getProductDao(int tipo) {
        switch (tipo) {
            case MEMORY: return new ProductDaoMemory();
            case FILE: return new ProductDaoFile();
            default: return null;
        }
    }
}
