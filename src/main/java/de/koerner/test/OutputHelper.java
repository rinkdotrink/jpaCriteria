package de.koerner.test;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Tuple;

public class OutputHelper {

    public static void output(Object o) {
        if (o == null) {
            return;
        }
        if (o instanceof List) {
            List l = (List) o;
            outputList(l);
        }
    }

    public static void outputList(List l) {
        System.out.println("==========================");
        for (Object object : l) {
            if (object instanceof Object[]) {
                System.out.print("Array: ");
                Object[] arr = (Object[]) object;
                outputArrayLine(arr);
            }
            else if (object instanceof Tuple){
                System.out.print("Tuple: ");
                Tuple t = (Tuple)object;
                Object[] arr = t.toArray();
                outputArrayLine(arr);
            }
            
            else {
                System.out.print(object);
            }
            System.out.println("");
        }
        System.out.println("==========================");
    }
    
    public static void outputArrayLine(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof BigDecimal) {
                System.out.print(" " + (BigDecimal) arr[i]);
            } else {
                System.out.print(" "+arr[i].toString());
            }
        }
    }
    

}
