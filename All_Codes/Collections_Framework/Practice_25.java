//25. Perform add, remove, search and sort operations on an ArrayList of teachers.

import java.util.*;
import java.util.Scanner;

public class Practice_25{
    public static void main(String[] args){
        ArrayList<String> teacher = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\n\nEnter 0 to exit\nEnter the teacher name: ");
            String name = sc.nextLine();
            if (name.equals("0")){
                break;
            }
            teacher.add(name);

        }
        System.out.println("\n\nTeacher List is: "+teacher);

        System.out.print("\n\nEnter the teacher name to remove: ");
        String name = sc.nextLine();
        teacher.remove(name);

        System.out.print("\n\nEnter the teacher name to search: ");
        name = sc.nextLine();
        System.out.println("Teach in list: "+teacher.contains(name));
        
        Collections.sort(teacher);
        System.out.println("Sorted list is: "+teacher);
    }
}