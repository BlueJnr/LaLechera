/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.beans;

import bluejnr.util.Type;

/**
 *
 * @author kcuadror
 */
public class Product {

    private String code;
    private Type type;
    private String description;
    private int currentStock;
    private int finalStock;
    private String unitMeasure;

    public static class Builder {

        private String code = "";
        private Type type = Type.BUTTER;
        private String description = "";
        private int currentStock = 0;
        private int finalStock = 0;
        private String unitMeasure = "";

        public Product.Builder code(String code) {
            this.code = code;
            return this;
        }

        public Product.Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Product.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Product.Builder currentStock(int currentStock) {
            this.currentStock = currentStock;
            return this;
        }

        public Product.Builder finalStock(int finalStock) {
            this.finalStock = finalStock;
            return this;
        }

        public Product.Builder unitMeasure(String unitMeasure) {
            this.unitMeasure = unitMeasure;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    private Product() {
        super();
    }

    private Product(Product.Builder builder) {
        code = builder.code;
        type = builder.type;
        description = builder.description;
        currentStock = builder.currentStock;
        finalStock = builder.finalStock;
        unitMeasure = builder.unitMeasure;
    }

    public String getCode() {
        return code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getFinalStock() {
        return finalStock;
    }

    public void setFinalStock(int finalStock) {
        this.finalStock = finalStock;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", type=" + type + ", description=" + description + ", currentStock=" + currentStock + ", finalStock=" + finalStock + ", unitMeasure=" + unitMeasure + '}';
    }
    
    
}
