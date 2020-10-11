/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao.impl;

import bluejnr.beans.Product;
import bluejnr.dao.ProductDao;
import bluejnr.util.Document;
import bluejnr.util.Price;
import bluejnr.util.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author kcuadror
 */
public class ProductDaoMemory implements ProductDao{

    private List<Product> products;

    public ProductDaoMemory() {
        products = new ArrayList<>();
    }

    @Override
    public void create(Product t) {
        if (find(t.getCode()) == null) {
            products.add(t);
        }
    }

    @Override
    public void update(Product t) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(t.getCode())) {
                products.set(i, t);
                break;
            }
        }
    }
    
    
    @Override
    public void delete(String v) {
        products.remove(find(v));
    }

    @Override
    public Product find(String v) {
        for(Product product:products){
            if(product.getCode().equals(v))
                return product;
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public double calculateTotal(int quantity, Type type) {
        return Price.byType(type)*quantity;
    }

    @Override
    public List<Product> findByType(Type type) {
        return products.stream()
                .filter(product -> product.getType() == type)
                .collect(Collectors.toList());
    }

    @Override
    public int stockTotalByType(Type type) {
        return products.stream()
                .filter(product -> product.getType() == type)
                .findFirst()
                .get()
                .getFinalStock();
    }

}
