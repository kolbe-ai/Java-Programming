//30 Demonstrate union, intersection and difference using HashSet.

import java.util.*;

public class Practice_30{
    public static void main(String[] args){
        HashSet <Integer> setA = new HashSet<>();
        HashSet <Integer> setB = new HashSet<>();
        
        HashSet <Integer> operation = new HashSet<>(setA);

        //adding set A
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);

        //adding set B
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);

        System.out.println("\nSet A: "+setA);
        System.out.println("\nSet B: "+setB);

        //union
        operation.addAll(setB);
        System.out.println("\nUnion of set is: "+operation);

        //intersection
        operation = new HashSet<>(setA);        //resetting
        operation.retainAll(setB);
        System.out.println("\nIntersection of set is: "+operation);

        //difference
        operation = new HashSet<>(setA);         //resetting
        operation.removeAll(setB);
        System.out.println("\nDifference of setA - setB: "+operation);

        //difference
        operation = new HashSet<> (setB);
        operation.removeAll(setA);
        System.out.println("\nDifference of setB - setA: "+operation);
    }
}