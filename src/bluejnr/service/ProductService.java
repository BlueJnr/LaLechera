/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.service;

import bluejnr.beans.Person;
import bluejnr.beans.Product;
import bluejnr.util.Type;
import java.util.List;

/**
 *
 * @author kcuadror
 */
public interface ProductService extends EntityService<Product, String> {    
    public abstract double sell(Person person, Product product, int quantity);
    public abstract List<Product> findByType(Type type);
    public abstract int stockTotalByType(Type type);
}
