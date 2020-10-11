/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.pruebas;

import bluejnr.beans.LegalPerson;
import bluejnr.beans.NaturalPerson;
import bluejnr.beans.Order;
import bluejnr.beans.Person;
import bluejnr.beans.Product;
import bluejnr.service.OrderService;
import bluejnr.service.ProductService;
import bluejnr.service.impl.OrderServiceImpl;
import bluejnr.service.impl.ProductServiceImpl;
import static bluejnr.util.Document.DNI;
import static bluejnr.util.Document.RUC;
import static bluejnr.util.Type.BUTTER;
import static bluejnr.util.Type.CHEESE;
import static bluejnr.util.Type.MILK;

/**
 *
 * @author kcuadror
 */
public class Prueba05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProductService productService = new ProductServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        
        Product product1 = new Product.Builder()
                .code("C001")
                .type(CHEESE)
                .description("Queso Laive")
                .currentStock(8000)
                .finalStock(8000)
                .unitMeasure("Molde de Kilo")
                .build();
        
        Product product2 = new Product.Builder()
                .code("C001")
                .type(MILK)
                .description("Queso Laive")
                .currentStock(8000)
                .finalStock(8000)
                .unitMeasure("Molde de Kilo")
                .build();
        
        Product product3 = new Product.Builder()
                .code("C003")
                .type(BUTTER)
                .description("Mantequilla Bella Holandesa")
                .currentStock(12000)
                .finalStock(12000)
                .unitMeasure("Barra")
                .build();
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
        
        Person person1 = new LegalPerson("Tienda01", RUC, "1234567890", "address01", "email01@gmai.com", "123456789");
        Person person2 = new NaturalPerson("Paterno01", "Materno01", "Name01", DNI, "12345678", "address03", "email02@gmai.com", "765347987");
        Person person3 = new LegalPerson("Tienda02", RUC, "0987654321", "address02", "email02@gmai.com", "987654321");
        
        System.out.println("Primera compra:");
        System.out.println(person3);
        System.out.println(product1);
        System.out.println("cantidad: " + 300);
        double total = productService.sell(person3, product1, 300);
        System.out.println("Total: " + total);
        if (total > 0) {
            Order order = new Order(300, person3.getDocumentNumber(), product1.getCode());
            orderService.create(order);
        }
        
        System.out.println("Segunda compra:");
        System.out.println(person2);
        System.out.println(product3);
        System.out.println("cantidad: " + 100);
        total = productService.sell(person2, product3, 100);
        System.out.println("Total: " + total);
        if (total > 0) {
            Order order = new Order(100, person2.getDocumentNumber(), product3.getCode());
            orderService.create(order);
        }

        System.out.println("Tercera compra:");
        System.out.println(person1);
        System.out.println(product2);
        System.out.println("cantidad: " + 150);
        System.out.println("No es multiplo de 100:");
        total = productService.sell(person1, product2, 150);
        System.out.println("Total: " + total);
        if (total > 0) {
            Order order = new Order(150, person1.getDocumentNumber(), product2.getCode());
            orderService.create(order);
        }
    }
    
}
