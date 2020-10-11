/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.pruebas;

import bluejnr.beans.Order;
import bluejnr.service.OrderService;
import bluejnr.service.impl.OrderServiceImpl;

/**
 *
 * @author kcuadror
 */
public class Prueba02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        Order order1 = new Order(10, "12345678", "C001");
        Order order2 = new Order(24, "87654321", "C002");
        Order order3 = new Order(17, "45678912", "C003");
        orderService.create(order1);
        orderService.create(order2);
        orderService.create(order3);

        System.out.println("Lista de Pedidos");
        orderService.findAll().stream().forEach((order) -> {
            System.out.println(order);
        });

        System.out.println("Buscar numero de pedido 3: " + orderService.find(3));
        order2.setQuantity(50);
        orderService.update(order2);
        orderService.delete(3);

        System.out.println("Lista de Pedidos actual");
        orderService.findAll().stream().forEach((order) -> {
            System.out.println(order);
        });
    }

}
