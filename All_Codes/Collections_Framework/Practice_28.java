//28 Create a contact directory using a LinkedList.

import java.util.*;

public class Practice_28{
    public static void main (String[] args){
        LinkedList <String> contact = new LinkedList <>();
        contact.add("Ravi");
        contact.add("Rahul");
        contact.add("John");
        contact.add("Riya");
        System.out.println("Contacts are: "+contact);
        contact.addFirst("Rilo");
        System.out.println("Contacts are: "+contact);
        contact.addLast("Xiya");
        System.out.println("Contancts are: "+contact);

        System.out.println("\n\nRemoving John from contacts");
        contact.remove("John");
        System.out.println("Checking if John is there: "+contact.contains("John"));

    }
}