/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.beans;

import bluejnr.util.Util;
import java.time.LocalDate;

/**
 *
 * @author kcuadror
 */
public class Order {

    private int number;
    private LocalDate date;
    private int quantity;
    private String documentNumber;
    private String productCode;

    public Order(int quantity, String documentNumber, String productCode) {
        this.number = Util.generateNumber();
        this.date = LocalDate.now();
        this.quantity = quantity;
        this.documentNumber = documentNumber;
        this.productCode = productCode;
    }

    public static class Builder {

        private int number = 0;
        private LocalDate date = LocalDate.of(1,1,1);
        private int quantity = 0;
        private String documentNumber = "";
        private String productCode = "";

        public Order.Builder number(int number) {
            this.number = number;
            return this;
        }

        public Order.Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Order.Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Order.Builder documentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
            return this;
        }

        public Order.Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
    
    private Order() {
        super();
    }

    private Order(Order.Builder builder) {
        this.number = builder.number;
        this.date = builder.date;
        this.quantity = builder.quantity;
        this.documentNumber = builder.documentNumber;
        this.productCode = builder.productCode;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "Order{" + "number=" + number + ", date=" + date + ", quantity=" + quantity + ", documentNumber=" + documentNumber + ", productCode=" + productCode + '}';
    }
}
