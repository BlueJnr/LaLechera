/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.pruebas;

import bluejnr.beans.Product;
import bluejnr.service.ProductService;
import bluejnr.service.impl.ProductServiceImpl;
import static bluejnr.util.Type.BUTTER;
import static bluejnr.util.Type.CHEESE;
import static bluejnr.util.Type.MILK;

/**
 *
 * @author kcuadror
 */
public class Prueba04 {

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

        System.out.println("Lista de Productos que son CHEESE");
        productService.findByType(CHEESE).stream().forEach((product) -> {
            System.out.println(product);
        });

        System.out.println("Lista de Productos que son MILK");
        productService.findByType(MILK).stream().forEach((product) -> {
            System.out.println(product);
        });

        System.out.println("Lista de Productos que son BUTTER");
        productService.findByType(BUTTER).stream().forEach((product) -> {
            System.out.println(product);
        });
        
        System.out.println("Stock de Productos que son CHEESE");
        System.out.println(productService.stockTotalByType(CHEESE));

        System.out.println("Stock de Productos que son MILK");
        System.out.println(productService.stockTotalByType(MILK));

        System.out.println("Stock de Productos que son BUTTER");
        System.out.println(productService.stockTotalByType(BUTTER));
    }

}
