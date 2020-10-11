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
public class Util {
   public static int i =1;
   
   public static double MAXPROM= 13;
   
   public static final double IGV=0.18;
   
   public static final int MEMORY=0;
   public static final int FILE=1;
   public static final int DB=2;
   
   public static final String APROBADO="Paso el curso";
   public static final String DESAPROBADO="Jalado";
   
   public static int opc =FILE;
    
    public static int generateNumber(){
        return i++;
    }
}