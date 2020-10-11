/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao.impl;

import bluejnr.beans.Product;
import bluejnr.dao.ProductDao;
import bluejnr.util.Price;
import bluejnr.util.Type;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 *
 * @author kcuadror
 */
public class ProductDaoFile implements ProductDao {

    private List<Product> products;

    public ProductDaoFile() {
        products = new ArrayList<>();
        readProducts();
    }

    @Override
    public void create(Product t) {
        if (find(t.getCode()) == null) {
            products.add(t);
            saveProducts();
        }
    }

    @Override
    public void update(Product t) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(t.getCode())) {
                products.set(i, t);
                saveProducts();
                break;
            }
        }
    }

    @Override
    public void delete(String v) {
        products.remove(find(v));
        saveProducts();
    }

    @Override
    public Product find(String v) {
        readProducts();
        for (Product product : products) {
            if (product.getCode().equals(v)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        readProducts();
        return products;
    }

    @Override
    public double calculateTotal(int quantity, Type type) {
        return Price.byType(type) * quantity;
    }

    @Override
    public List<Product> findByType(Type type) {
        readProducts();
        return products.stream()
                .filter(product -> product.getType() == type)
                .collect(Collectors.toList());
    }

    @Override
    public int stockTotalByType(Type type) {
        readProducts();
        return products.stream()
                .filter(product -> product.getType() == type)
                .findFirst()
                .get()
                .getFinalStock();
    }

    private void saveProducts() {
        String linea;
        try (BufferedWriter bufOutput = new BufferedWriter(new FileWriter("products.txt"))) {
            for (Product product : products) {
                linea = product.getCode() + ","
                        + product.getType() + ","
                        + product.getDescription() + ","
                        + product.getCurrentStock() + ","
                        + product.getFinalStock() + ","
                        + product.getUnitMeasure();
                bufOutput.write(linea);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("[grabar] Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo grabar products.txt: " + e);
        }
    }

    private void readProducts() {
        try (BufferedReader bufInput = new BufferedReader(new FileReader("products.txt"))) {
            String linea;
            products.clear();
            while ((linea = bufInput.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                products.add(new Product.Builder()
                        .code(tokens.nextToken().trim())
                        .type(Type.valueOf(tokens.nextToken().trim()))
                        .description(tokens.nextToken().trim())
                        .currentStock(Integer.parseInt(tokens.nextToken().trim()))
                        .finalStock(Integer.parseInt(tokens.nextToken().trim()))
                        .unitMeasure(tokens.nextToken().trim())
                        .build());
            }
        } catch (FileNotFoundException f) {
            System.out.println("[leer]Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo leer products.txt: " + e);
        }
    }

}
