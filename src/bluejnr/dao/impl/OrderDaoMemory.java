/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao.impl;

import bluejnr.beans.Order;
import bluejnr.dao.OrderDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kcuadror
 */
public class OrderDaoMemory implements OrderDao {

    private List<Order> orders;

    public OrderDaoMemory() {
        orders = new ArrayList<>();
    }

    @Override
    public void create(Order t) {
        if (find(t.getNumber()) == null) {
            orders.add(t);
        }
    }

    @Override
    public void update(Order t) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getNumber() == t.getNumber()) {
                orders.set(i, t);
                break;
            }
        }
    }
    
    
    @Override
    public void delete(Integer v) {
        orders.remove(find(v));
    }

    @Override
    public Order find(Integer v) {
        for (Order order : orders) {
            if (order.getNumber() == v) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public Order findByDocumentNumber(String documentNumber) {
        for (Order order : orders) {
            if (order.getDocumentNumber().equals(documentNumber)) {
                return order;
            }
        }
        return null;
    }
}
