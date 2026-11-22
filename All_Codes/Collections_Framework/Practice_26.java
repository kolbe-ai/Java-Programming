//26. Store teacher details (ID → name) using a HashMap.

import java.util.*;
public class Practice_26{
    public static void main(String[] args){
        HashMap <Integer, String> teacher= new HashMap<>();
        teacher.put(101,"Ravi");
        teacher.put(102,"Rahul");
        teacher.put(103,"Ronny");
        System.out.print("\n\nAll list of teachers is: "+teacher);

        System.out.print("\n\nDeleting Rahul: ");
        teacher.remove(102);
        System.out.print("\nAll list of teachers is: "+teacher);

        System.out.print("\n\nChecking if Rahul still there: ");
        System.out.print("\nIs teacher: "+teacher.containsKey(102));
    }
}