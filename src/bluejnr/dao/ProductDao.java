/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao;

import bluejnr.beans.Product;
import bluejnr.util.Type;
import java.util.List;

/**
 *
 * @author kcuadror
 */
public interface ProductDao extends EntityDao<Product, String> {
    public abstract double calculateTotal(int quantity, Type type);
    public abstract List<Product> findByType(Type type);
    public abstract int stockTotalByType(Type type);
}
