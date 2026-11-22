//29 Implement a simple grocery inventory (item → quantity) using a TreeMap.

import java.util.*;

public class Practice_29{
    public static void main(String[] args){
        TreeMap <Integer,String> grocery = new TreeMap <>();
        grocery.put(101,"Apple");
        grocery.put(102,"Mango");
        grocery.put(103,"Orange");
        grocery.put(104,"Jackfruit");
        System.out.println("\nList of grocery is: "+grocery);
        
        //removing Apple
        grocery.remove(101);
        System.out.println("\nApple removed!");
        
        //searching apple
        System.out.println("\nApple in grocery list: "+grocery.containsKey(101));
    }
}