/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.pruebas;

import bluejnr.beans.Order;
import bluejnr.beans.Product;
import bluejnr.service.OrderService;
import bluejnr.service.ProductService;
import bluejnr.service.impl.OrderServiceImpl;
import bluejnr.service.impl.ProductServiceImpl;
import static bluejnr.util.Type.CHEESE;
import static bluejnr.util.Type.MILK;
import static bluejnr.util.Type.BUTTER;

/**
 *
 * @author kcuadror
 */
public class Prueba01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        productService.create(new Product.Builder()
                .code("C001")
                .type(CHEESE)
                .description("Queso Laive")
                .currentStock(8000)
                .finalStock(8000)
                .unitMeasure("Molde de Kilo")
                .build());
        productService.create(new Product.Builder()
                .code("C002")
                .type(MILK)
                .description("Leche evaporada Gloria")
                .currentStock(10200)
                .finalStock(10200)
                .unitMeasure("Caja")
                .build());
        productService.create(new Product.Builder()
                .code("C003")
                .type(BUTTER)
                .description("Mantequilla Bella Holandesa")
                .currentStock(12000)
                .finalStock(12000)
                .unitMeasure("Barra")
                .build());
        
        System.out.println("Lista de Productos");
        productService.findAll().stream().forEach((product) -> {
            System.out.println(product);
        });
        
        System.out.println("Buscar C003: " + productService.find("C003"));
        productService.update(new Product.Builder()
                .code("C002")
                .type(MILK)
                .description("Leche evaporada Laive")
                .currentStock(10200)
                .finalStock(10200)
                .unitMeasure("Barra")
                .build());
        productService.delete("C003");
        
        System.out.println("Lista de Productos actual");
        productService.findAll().stream().forEach((product) -> {
            System.out.println(product);
        });
        
        
        
    }
    
}
