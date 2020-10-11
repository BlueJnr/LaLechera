/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.util;

/**
 *
 * @author kcuadror
 */
public enum Price {
    
    CHEESE(10.00),
    MILK(8.00),
    BUTTER(3.00);
    
    private final double price;
    
    Price(double price){
        this.price = price;
    }
    
    public double price(){
        return price;
    }
   
    public static double byType(Type t){
        
        double productPrice = 0.0d;
        
        switch(t){
            case CHEESE: productPrice = CHEESE.price; break;
            case MILK: productPrice = MILK.price; break;
            case BUTTER: productPrice = BUTTER.price; break;
        }
        
        return productPrice;
    }
}
