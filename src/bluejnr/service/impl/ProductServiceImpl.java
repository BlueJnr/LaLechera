/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.service.impl;

import bluejnr.beans.Person;
import bluejnr.beans.Product;
import bluejnr.dao.ProductDao;
import bluejnr.dao.impl.DaoFactory;
import bluejnr.service.ProductService;
import static bluejnr.util.Document.DNI;
import static bluejnr.util.Document.RUC;
import bluejnr.util.Type;
import static bluejnr.util.Util.opc;
import java.util.List;

/**
 *
 * @author kcuadror
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao dao;

    public ProductServiceImpl() {
        DaoFactory factory = DaoFactory.getInstance();
        dao = factory.getProductDao(opc);
    }

    @Override
    public void create(Product t) {
        dao.create(t);
    }

    @Override
    public void update(Product t) {
        dao.update(t);
    }

    @Override
    public void delete(String v) {
        dao.delete(v);
    }

    @Override
    public Product find(String v) {
        return dao.find(v);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public double sell(Person person, Product product, int quantity) {
        double total = 0;
        if (dao.stockTotalByType(product.getType()) >= quantity
                && ((person.getDocument() == DNI && quantity <= 100)
                || (person.getDocument() == RUC && quantity % 100 == 0))) {
            total = dao.calculateTotal(quantity, product.getType());
            product.setFinalStock(product.getFinalStock() - quantity);
            dao.update(product); 
        }

        return total;
    }

    @Override
    public int stockTotalByType(Type type) {
       return  dao.stockTotalByType(type);
    }

    @Override
    public List<Product> findByType(Type type) {
        return dao.findByType(type);
    }

}
