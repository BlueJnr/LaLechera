/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao.impl;

import bluejnr.beans.Order;
import bluejnr.dao.OrderDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

/**
 *
 * @author kcuadror
 */
public class OrderDaoFile implements OrderDao {

    private List<Order> orders;

    public OrderDaoFile() {
        orders = new ArrayList<>();
        readOrders();
    }

    @Override
    public void create(Order t) {
        if (findByDocumentNumber(t.getDocumentNumber()) == null) {
            orders.add(t);
            saveOrders();
        }
    }

    @Override
    public void update(Order t) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getNumber() == t.getNumber()) {
                orders.set(i, t);
                saveOrders();
                break;
            }
        }
    }

    @Override
    public void delete(Integer v) {
        orders.remove(find(v));
        saveOrders();
    }

    @Override
    public Order find(Integer v) {
        readOrders();
        for (Order order : orders) {
            if (order.getNumber() == v) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order findByDocumentNumber(String documentNumber) {
        readOrders();
        for (Order order : orders) {
            if (order.getDocumentNumber().equals(documentNumber)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    private void saveOrders() {
        String linea;
        try (BufferedWriter bufOutput = new BufferedWriter(new FileWriter("orders.txt"))) {
            for (Order order : orders) {
                linea = order.getNumber() + ","
                        + order.getDate() + ","
                        + order.getQuantity() + ","
                        + order.getDocumentNumber() + ","
                        + order.getProductCode();
                bufOutput.write(linea);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("[grabar] Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo grabar orders.txt: " + e);
        }
    }

    private void readOrders() {
        try (BufferedReader bufInput = new BufferedReader(new FileReader("orders.txt"))) {
            String linea;
            orders.clear();
            while ((linea = bufInput.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                orders.add(new Order.Builder()
                        .number(Integer.parseInt(tokens.nextToken().trim()))
                        .date(LocalDate.parse(tokens.nextToken().trim()))
                        .quantity(Integer.parseInt(tokens.nextToken().trim()))
                        .documentNumber(tokens.nextToken().trim())
                        .productCode(tokens.nextToken().trim())
                        .build());
            }
        } catch (FileNotFoundException f) {
            System.out.println("[leer]Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo leer orders.txt: " + e);
        }
    }

}
