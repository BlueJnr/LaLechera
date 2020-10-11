/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.service.impl;

import bluejnr.beans.Order;
import bluejnr.dao.OrderDao;
import bluejnr.dao.impl.DaoFactory;
import bluejnr.service.OrderService;
import static bluejnr.util.Util.opc;
import java.util.List;

/**
 *
 * @author kcuadror
 */
public class OrderServiceImpl implements OrderService{

    private OrderDao dao;

    public OrderServiceImpl() {
        DaoFactory factory = DaoFactory.getInstance();
        dao = factory.getOrderDao(opc);
    }
    
    @Override
    public void create(Order t) {
        if (dao.findByDocumentNumber(t.getDocumentNumber()) == null) {
            dao.create(t);
        }
    }

    @Override
    public void update(Order t) {
        dao.update(t);
    }

    @Override
    public void delete(Integer v) {
        dao.delete(v);
    }

    @Override
    public Order find(Integer v) {
        return dao.find(v);
    }

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }
    
}
