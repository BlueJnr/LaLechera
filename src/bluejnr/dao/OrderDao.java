/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao;

import bluejnr.beans.Order;

/**
 *
 * @author kcuadror
 */
public interface OrderDao extends EntityDao<Order, Integer> {
    public abstract Order findByDocumentNumber(String documentNumber);
}
